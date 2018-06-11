package bop;

import java.util.Scanner;

public class MoBai {
public static void main(String[] args){
	Scanner s = new Scanner(System.in);
	int n = s.nextInt();
	int a[] = new int[n];
	for(int i = 0; i < n; i++){
		a[i] = s.nextInt();
	}
	int min = Integer.MAX_VALUE;
	int k = 0;
	int end = 0;
	for(int i = 0; i < n; i++){
		if(min > a[i]){
			min = a[i];
			k = i;
		}
	}
	end = k;
	for(int i = k; i < n - 1; i++){
		if(a[k] + 1 > a[k]){
			k++;
		}
		else {
			break;
		}
	}
	
	for(int i = 0; i < k; i++){
		for(int j = k; j <= end; j++){
			if(a[i] < a[j]){
				end = end - 1;
			}
		}
	}
	for(int i = k+1; i < n; i++){
		for(int j = k; j <= end; j++){
			if(a[i] < a[j]){
				end = end - 1;
			}
		}
	}
	int c = n - (end - k + 1);
	System.out.println(c);
}
}
