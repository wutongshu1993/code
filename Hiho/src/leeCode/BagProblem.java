package leeCode;

import java.util.Scanner;

/**
 * 背包问题
 * @author lh
 *
 */
public class BagProblem {
public static void main(String[] args){
	Scanner in = new Scanner(System.in);
	int n = in.nextInt();
	int m = in.nextInt();
	int[] w = new int[n];
	int[] d = new int[n];
	for(int i = 0; i < n; i++){
		w[i] = in.nextInt();
		d[i] = in.nextInt();
	}
	
	System.out.println(new BagProblem().bagProblem2(n, m, w, d));
}
//最朴素的做法，容易memory limit exceeded
public int bagProblem(int n, int m, int[] w, int[] d){
	int[][] dp = new int[n + 1][m + 1];
	for(int i = 1; i <= n; i++){
		for(int j = 0; j <= m; j++){
			dp[i][j] = Math.max(dp[i-1][j],dp[i][j]);	
			if(j >= w[i-1]){
				dp[i][j] = Math.max(dp[i][j],  dp[i-1][j-w[i-1]] + d[i-1]);
			}
		}
		
	}
	return dp[n][m];
}
//滚动数组优化法
public int bagProblem2(int n, int m, int[] w, int[] d){
	int[][] dp = new int[2][m + 1];
	for(int i = 1; i <= n; i++){
		int row = i & 1;//
		for(int j = 0; j <= m; j++){
			dp[row][j] = Math.max(dp[row ^ 1][j],dp[row][j]);	
			if(j >= w[i-1]){
				dp[row][j] = Math.max(dp[row][j],  dp[row ^ 1][j-w[i-1]] + d[i-1]);
			}
		}
		
	}
	return Math.max(dp[0][m], dp[1][m]);
}
}
