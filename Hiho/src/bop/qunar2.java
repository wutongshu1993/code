package bop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
class Hotel{
	int seq;
	int min;
	double ava;
	
	public Hotel(int seq, int min, double ava) {
		super();
		this.seq = seq;
		this.min = min;
		this.ava = ava;
	}
}
public class qunar2 {
	
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		while(s.hasNext()){
			int n = s.nextInt(); 
			int[][] ranks = new int[n][5];
			int[] res = new int[n];
			Hotel[] hotels = new Hotel[n];
			for(int i = 0; i < n; i++){
				int min = 5;
				double total = 0;
				for(int j = 0; j < 5; j++){
					ranks[i][j] = s.nextInt();
					if(ranks[i][j] < min){
						min = ranks[i][j];
					}
					total += ranks[i][j];
				}
				Hotel item = new Hotel(i, min, total / 5.0);
				hotels[i] = item;
				
			}
			Arrays.sort(hotels, new Comparator<Hotel>() {

				@Override
				public int compare(Hotel o1, Hotel o2) {
					// TODO Auto-generated method stub
					if(o1.min == o2.min){
						 if((Math.abs(o1.ava - o2.ava))< 0.00001){
							 return o1.seq - o2.seq;
						 }
						 else {
							 if(o2.ava > o1.ava){
								 return 1;
							 }
							 else {
								return -1;
							}
							
						}
					}
					else {
						return o2.min - o1.min;
					}
					
				}
				
			});
			for(int i = 0; i < n; i++){
				System.out.print(hotels[i].seq+" ");
				
			}
			System.out.println();
			
		}
	}
}
