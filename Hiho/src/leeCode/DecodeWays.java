package leeCode;

import java.util.HashMap;
import java.util.Map;

public class DecodeWays {

/**
 * dp[i]表示长度为i的时候，有多少种方式解码
 * I used a dp array of size n + 1 to save subproblem solutions.
 *  dp[0] means an empty string will have one way to decode, 
 *  dp[1] means the way to decode a string of size 1. 
 *  I then check one digit and two digit combination and save the results along the way. 
 * In the end, dp[n] will be the end result.
 * @param s
 * @return
 */
public int numDecodings(String s) {
     if(s == null || s.length() == 0){
    	 return 0;
     }   
     int[] dp = new int[s.length() + 1];
     dp[0] = 1;
     dp[1] = s.charAt(0) == '0' ? 0 : 1;
     int n = s.length();
     for(int i = 2; i <= n; i++){
    	 int first = Integer.valueOf(s.substring(i-1, i));
    	 int second = Integer.valueOf(s.substring(i-2, i));
    	 if(first >= 1 && first <= 9){
    		 dp[i] += dp[i - 1];//当加一个数之后，把这个数单独的加在后面，和dp[i-1]的情况相同
    	 }
    	 if(second >= 10 && second <= 26){
    		 dp[i] += dp[i - 2];  //当新加的这个数和前面的数组成了一个新的数，这种情况就要在原来的基础上再加上dp[i-2]
    	 }
     }
	return dp[n];
    }


public static void main(String[] args){
	System.out.println(new DecodeWays().numDecodings("1212"));
}
}
