package bop;

import java.util.Arrays;
import java.util.Scanner;



public class bcz2 {
	static int k = 0;
	public static void main(String[] args){
	Scanner in = new Scanner(System.in);
	while(in.hasNext()){
		k=0;
		int n = in.nextInt();
		int[] a = new int[n];
		for(int i = 0; i <n; i++) {
			a[i] = in.nextInt();
		}
		Arrays.sort(a);
		int sum = in.nextInt();
		
		find(a,n, sum);
		if (k==1) {
			System.out.println(true);
		}else {
			System.out.println(false);
		}
	}
	
}
	public static void find(int[] a, int n, int sum) {
		if(n <= 0 || sum<= 0){
			return;
		}
		
		if(sum == a[n-1]){
			k=1;
		}
		
		find(a, n-1, sum-a[n-1]);
		find(a, n-1, sum);
	}
	
	public static boolean find2(int[] a, int n, int k) {
		int i = 0;
		int j = n-1;
		while(i < j) {
			if (a[i] + a[j] < k) {
				++i;
			}else if (a[i]+a[j] > k) {
				--j;
			}
			else {
				return true;
			}
		}
		return false;
	}
}
