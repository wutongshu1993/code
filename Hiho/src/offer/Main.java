package offer;

import java.util.Scanner;
/**
 * 给定一个字符串s，你可以从中删除一些字符，使得剩下的串是一个回文串。如何删除才能使得回文串最长呢？
输出需要删除的字符个数。
输入数据有多组，每组包含一个字符串s，且保证:1<=s.length<=1000.
对于每组数据，输出一个整数，代表最少需要删除的字符个数。如abcda  google 输出2  2
 * @author Administrator
 *
 */
public class Main {
	public static void main(String[] args) throws InterruptedException {
		getResult();
		
	}
	public static void getResult(){
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			String str = scanner.nextLine();
			System.out.println(str.length() - LCS(str, new StringBuilder(str).reverse().toString()));
		}
		scanner.close();
	}
	public static int LCS(String a, String b){
		//dp[i][j]表示a的0~i与b的0~j的最长公共子序列长度
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
}
