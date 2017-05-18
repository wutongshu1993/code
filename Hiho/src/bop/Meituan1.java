package bop;

import java.util.ArrayList;
import java.util.Scanner;

public class Meituan1 {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		while(s.hasNext()){
			int m = s.nextInt();
			int[] arr1 = new int[m];
			int n = s.nextInt();
			int[] arr2 = new int[n];
			for(int i = 0; i < m; i++){
				arr1[i] = s.nextInt();
			}
			for(int i= 0; i < n; i++){
				arr2[i] = s.nextInt();
			}
			int[] res = findSame(arr1, arr2);
			for(int i = 0; i< res.length; i++){
				System.out.print(res[i]+" ");
			}
		}
	}
public  static int[] findSame(int[] arr1, int[] arr2){
	int i = 0;
	int j = arr2.length -1 ;
	ArrayList<Integer> res = new ArrayList<>();
	while(i < arr1.length && j >= 0){
		if(arr1[i] < arr2[j]){
			i++;
		}
		else if(arr1[i] > arr2[j]){
			j--;
		}
		else {
			res.add(arr1[i]);
			i++;
			j--;
		}
	}
	int[] ret = new int[res.size()];
	for(int k = 0; k < res.size(); k++){
		ret[k] = res.get(k);
	}
	return ret;
}
}
