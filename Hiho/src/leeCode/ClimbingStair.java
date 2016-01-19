package leeCode;
/**
 * You are climbing a stair case. It takes n steps to reach to the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways
 can you climb to the top?
 * @author lh
 *
 */
public class ClimbingStair {
	public int climbStairs(int n){
		int a[] = new int[n+1];
		int b[] = new int[2];
		if (n<=2) {
			return n;
		}
		else {		
		a[0] = 0;
		a[1] = 1;
		a[2] = 2;
		for(int i=3;i<=n;i++){
			a[i] = a[i-1]+a[i-2];
		}
//			return climbStairs(n-1)+climbStairs(n-2);
		return a[n];
		}
		
	}
	public static void main(String[] args){
		System.out.println(new ClimbingStair().climbStairs(1));
	}
}
