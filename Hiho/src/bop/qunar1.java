package bop;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class qunar1 {
public static void main(String[] args){
	Scanner s = new Scanner(System.in);
	while(s.hasNext()){
		int num = s.nextInt();
		HashSet<Integer> set = new HashSet<>();
		int total = 0;
		for(int i = 0; i < num; i++){
			int seq = s.nextInt();
			int ok = s.nextInt();
			int explain = s.nextInt();
			
			if(ok == 1 && explain == 1){
				total += 30;
			}
			else{
				if(set.contains(seq)){
					if(ok == 1 && explain == 0){
						total += 5;
					}
					else if(ok == 1){
						total += 10;
					}
				}
				else {
					if(ok == 1 && explain == 0){
						total += 10;
					}
				}
			}
			if(ok == 1){
				set.add(seq);
			}
			
			
		}
		System.out.println(total);
	}
}
}
