package bop;

import java.util.Scanner;

public class ShiftUpperCase {
public static void main(String[] args){
	Scanner s = new Scanner(System.in);
	while(s.hasNext()){
		String str = s.next();
		int j = 0;
		for(int i= 0; i < str.length() && j < str.length(); i++){
			if(str.charAt(j) >= 'a' && str.charAt(j) <= 'z' && str.charAt(i) >= 'A' && str.charAt(i) <='Z' ){
				str = swap(str, i, j);
				i++;
				j++;
			}
			else {
				
			}
		}
	}
}
//½«i j½»»»
public static String swap(String str, int i, int j){
	StringBuffer buffer = new StringBuffer();
	for(int k = 0; k < i; k++){
		if(k == i){
			buffer.append(str.charAt(j));
		}
		else if(k == j){
			buffer.append(str.charAt(i));
		}
		else {
			buffer.append(str.charAt(k));
		}
		
	}
	return buffer.toString();
}
}
