package bop;

import java.util.Arrays;
import java.util.Scanner;

public class toutiao3 {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		while(s.hasNext()){
			int n = s.nextInt();
			int q = s.nextInt();
			
			int[] a = new int[n];
			for(int i = 0; i < n; i++){
				a[i] = s.nextInt();
			}
			Arrays.sort(a);
			int[] b = new int[n];
			for(int i = 0; i < n; i++){
				b[i] = s.nextInt();
			}
			Arrays.sort(b);
			int[][] query = new int[q][2];
			for(int i = 0; i < q; i++){
				query[i][0] = s.nextInt();
				query[i][1] = s.nextInt() ;
			}
			
			for(int i = 0; i < q; i++){
				int count1 = 0;
				for(int j = 0; j < n; j++){
					if(a[j] >= query[i][0] && b[j] >= query[i][1]){
						count1 = n - j;
						break;
					}

				}
				System.out.println(count1);
			}
			
		}
	}
}
