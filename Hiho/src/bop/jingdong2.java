package bop;

import java.text.DecimalFormat;
import java.util.Scanner;
/**
 * ����ÿ�ſ��Ե�ͨ���ʣ�Ҫ����60%�Ŀγ̲���ͨ��
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
		//��ʼ����
		int count =(int)(Math.ceil(n * 0.6));
		
		double res = dp(pi, count);
		DecimalFormat df = new DecimalFormat("#0.00000");
		System.out.println(df.format(res));
	}
	
}


//��ȫû���뵽������dp������,����ͨ��n�ſεĸ���
public static double dp(double[] p, int n){
	int len = p.length;
	double res = 0.0;;
	if(len < 1){
		return -1;
	}
	double[][] dp = new double[len+1][len+1];//dp[i][j]����ǰi�ſ�ͨ��j�ŵĸ���
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
 * ��C m n
 * @param n:����
 * @param m
 * @return
 */
public static int getCn(int n, int m){
	int res;
	int a = getJC(n);
	int b = getJC(m);
	return a / b;
}
//��m�Ľ׳�
public static int getJC(int m){
	int res = 1;
	for(int i = m; i > 0; i--){
		res *= i;
	}
	return res;
}
//���n����ĸ���
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
//��������ͨ��n����ĸ���
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
