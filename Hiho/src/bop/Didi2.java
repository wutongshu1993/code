package bop;

import java.util.Scanner;

public class Didi2 {
public static void main(String[] args){
	Scanner in = new Scanner(System.in);
	while(in.hasNext()){
		int n = in.nextInt();
		int x = in.nextInt() - 1;
		int[] a = new int[n];
		int min = Integer.MAX_VALUE;
		int k = 0;
		int oldak = 0;
		int old_a[] = new int[n];
		for(int i=0; i<n; i++){
			a[i] = in.nextInt();
			if(a[i] < min){
				min = a[i];
				k = i;
			}
		}
		for(int i = 0; i < n; i++){
			old_a[i] = a[i] - a[k];
		}
		
		if(x - k != 0){
			for(int i = k + 1; i < n; i++ ){
				old_a[i]--;
			}
			for(int i = 0; i <= x; i++){
				old_a[i]--;
			}
			oldak = n-k+x+n*a[k];
		}
		else{
			oldak = n * a[k];
		}
		old_a[k] = oldak;
		for(int i =0; i < n - 1; i++){
			System.out.print(old_a[i] + " ");
		}
		System.out.println(old_a[n-1]);		
	}
}
}
