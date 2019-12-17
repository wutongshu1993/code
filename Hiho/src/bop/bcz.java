package bop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class bcz {
	public static void main(String[] args){
	Scanner in = new Scanner(System.in);
	while(in.hasNext()){
		int n = in.nextInt();
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0; i <n; i++) {
			int k = in.nextInt();
			for(int j = 0; j < k; j++) {
				list.add(in.nextInt());
			}
		}
		Collections.sort(list);
		for(Integer t : list) {
			System.out.print(t+" ");
		}
		
	}
	
}
}
