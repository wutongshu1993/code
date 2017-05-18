package bop;
/**
 * 1:0种分解方法
 * 2:0种
 * 3=2+1 1
 * 4=3+1=2+1+1 2
 * 5=4+1=3+2=3+1+1=2+1+1+1 3
 * 6=5+1=4+2=4+1+1=3+2+1=3+1+1+1=2+2+1+1=2+1+1+1+1+1 7种
 * 规律：后面的加数小于等于前面的加数，且不能有所有加数都相同的情况.
 * @author lh
 *
 */
public class tencent1 {
public static void main(String[] args){
	Integer a = 2017, b = 2017;
	
	System.out.println(a == b);
	Integer c = 100, d = 100;
	System.out.println(c == d);
	//dp(7);
}
public static void dp(int n){
	int[][] dp = new int[n+1][n+1];
	int res = 0;
	for(int i = 1; i <= n; i++){
		dp[i][1] = 1;
		dp[i][i] = 1;
	}

	for(int i = 3; i <= n; i++){
		for(int j = i-1; j >=1; j--){
			for(int k = 1; k <= Math.min(i-j, j); k++){
				dp[i][j] += dp[i-j][k];
				dp[i][1] = 1;
			}
			System.out.println("dp["+i+"]["+j+"]="+dp[i][j]);
		}
	}
	for(int i = 2; i <= n; i++){
		res += dp[n][i];
	}
	for(int i = 2; i <= n; i++){
		if(n % i == 0){
			res--;
		}
	}
	System.out.println(res);
}
}
