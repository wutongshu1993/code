package bop;

import java.text.DecimalFormat;
import java.util.Scanner;
/**
 * 输入每门考试的通过率，要超过60%的课程才能通过
 * @author lh
 *
 */
public class jingdong2 {
public static void main(String[] args){
	Scanner s = new Scanner(System.in);
	
	while(s.hasNext()){
		int n = s.nextInt();
		double[] pi = new double[n];
		for(int i = 0; i < n; i++){
			pi[i] = (double)(s.nextInt() / 100.0);
		}
//		System.out.println(pi[0]);
		//开始处理
		int count =(int)(Math.ceil(n * 0.6));
		
		double res = dp(pi, count);
		DecimalFormat df = new DecimalFormat("#0.00000");
		System.out.println(df.format(res));
	}
	
}


//完全没有想到可以用dp来做啊,至少通过n门课的概率
public static double dp(double[] p, int n){
	int len = p.length;
	double res = 0.0;;
	if(len < 1){
		return -1;
	}
	double[][] dp = new double[len+1][len+1];//dp[i][j]代表前i门课通过j门的概率
	dp[0][0] = 1;
	for(int i = 1; i <= len ; i++){
		dp[i][0] = dp[i-1][0] * (1-p[i-1]);
		for(int j = 1; j <= i; j++){
			dp[i][j] = dp[i-1][j-1] * p[i-1] + dp[i-1][j] * (1-p[i-1]);
		}
	}
	for(int i = n; i <= len; i++ ){
		res += dp[len][i];
		
	}
	return res;
}






/**
 * 求C m n
 * @param n:底数
 * @param m
 * @return
 */
public static int getCn(int n, int m){
	int res;
	int a = getJC(n);
	int b = getJC(m);
	return a / b;
}
//求m的阶乘
public static int getJC(int m){
	int res = 1;
	for(int i = m; i > 0; i--){
		res *= i;
	}
	return res;
}
//答对n个题的概率
public static double getProp(int n, double[] p){
	double prop = 1;
	double res ;
	int len = p.length;
	for(int i = 0; i < n; i++){
		prop *= p[i];
	}
	for(int i = n; i < len; i++){
		prop *= (1-p[i]);
	}
	res = getCn(p.length, n) * prop;
	System.out.println(res);
	return res;
}
//计算至少通过n个题的概率
public static double getRes(int n, double[] p){
	double res = 0;
	int len = p.length;
	for(int i = n; i < len+1; i++ ){
		res += getProp(i, p);
	}
	System.out.println(res);
	return res;
}
}
