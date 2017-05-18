package bop;

import java.util.Scanner;

public class HuiWei1 {
public static void main(String[] args){
	Scanner in = new Scanner(System.in);
	while(in.hasNext()){
		String str = in.next();
		System.out.println(tranverse(str));
	}
}
public static String tranverse(String str){
	int res = 0;
	int len = str.length();
	for(int i = len -1 ; i >= 0; i--){
		res += Integer.parseInt(str.charAt(i)+"") * Math.pow(7, len-1-i);
	}
	return res+"";
}
}
