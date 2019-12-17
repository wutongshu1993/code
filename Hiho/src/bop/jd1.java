package bop;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class jd1 {
public static void main(String[] args){
	Scanner s = new Scanner(System.in);
	while(s.hasNext()){
		int n = s.nextInt();
		int[] arr = new int[n];
		double res;
		for(int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}
		Arrays.sort(arr);
		System.out.println(arr);
		if(n % 2 == 1) {//ÆæÊý
			res = arr[(n-1)/2];
		}else {
			int a = arr[(n-2)/2];
			int b = arr[n/2];
			int sum = a+b;
			res = sum / 2.f;
		}
		System.out.println(res);
	}
}
}
