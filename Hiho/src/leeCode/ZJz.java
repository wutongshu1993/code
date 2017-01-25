package leeCode;

import java.util.Scanner;

public class ZJz {
public static void main(String[] args){
	Scanner scanner = new Scanner(System.in);
	int n=0,m=0,p=0;
	int[] nums ;
	int j = 0;
	
		n = scanner.nextInt();
		m = scanner.nextInt();
		p = scanner.nextInt();
		
		
		
	
	nums = new int[n];
	
		while(j < n){
			nums[j++] = scanner.nextInt();
		}
		
	
	System.out.println(compute(n, m, p, nums));
	
}

public static int compute(int n, int m, int p, int[] nums){
	int sum = 0;
	int count = 0;
	for(int i = 0 ; i < n; i++){
		if(nums[i] >= p){
			count++;
		}
		if(nums[i] < p){
			count = 0;
		}
		if(count == m){
			count = 1;
			sum++;
		}
	}
	return sum;
}
}
