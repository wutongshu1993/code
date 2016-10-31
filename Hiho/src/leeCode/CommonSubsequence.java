package leeCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CommonSubsequence {
public static void main(String[] args) throws IOException{
//	BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
//	String line = stdin.readLine();
//	StringTokenizer st = new StringTokenizer(line);
//	String a = st.nextToken();
//	String b = st.nextToken();
	Scanner in = new Scanner(System.in);
	while(in.hasNext()){
		String a = in.next();
		String b = in.next();
		System.out.println(new CommonSubsequence().commonSubsequence(a, b));
	}
	
}
public int commonSubsequence(String a, String b){
	int m = a.length();
	int n = b.length();
	int[][] dp = new int[m + 1][n + 1];
	if(m == 0 || n == 0){
		return 0;
	}
//	for(int i = 0; i < m; i++){
//		if(a.charAt(0) == b.charAt(0)){
//			dp[i][0] = 1;
//		}
//		else {
//			dp[i][0] = 0;
//		}
//	}
//	for(int j = 0; j < n; j++){
//		if(a.charAt(0) == b.charAt(0)){
//			dp[0][j] = 1;
//		}
//		else {
//			dp[0][j] = 0;
//		}
//	}
//	dp[0][0] = a.charAt(0) == b.charAt(0) ? 1 : 0;
	for(int i = 1; i <= m; i++){
		for(int j = 1; j <= n; j++){
			dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			if(a.charAt(i-1) == b.charAt(j-1)){
				dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + 1);
			}
			else {
				dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1]);
			}
		}
	}
	return dp[m][n];
}
}
