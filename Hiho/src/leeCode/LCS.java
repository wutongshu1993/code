package leeCode;
/**
 * �����������
 * @author Administrator
 *
 */
public class LCS {
public int LCS(String a, String b){
	//dp[i][j]��ʾa��0~i��b��0~j������������г���
	int len1 = a.length();
	int len2 = b.length();
	int[][] dp = new int[len1+1][len2+1];
	
	for(int i = 1; i <= len1; i++){
		for(int j = 1; j <= len2; j++){
			if(a.charAt(i-1) == b.charAt(j-1)){
				dp[i][j] = dp[i-1][j-1] + 1;
			}
			else {
				dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
	}
	return dp[len1][len2];
}
public static void main(String[] args){
	System.out.println(new LCS().LCS("bdcaba", "abcbdab"));
}
}
