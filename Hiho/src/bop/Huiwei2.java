package bop;

import java.util.Arrays;
import java.util.Scanner;

import javax.naming.spi.DirStateFactory.Result;

public class Huiwei2 {
public static void main(String[] args){
	Scanner in = new Scanner(System.in);
	while(in.hasNext()){
		String str = in.next();
		for(int i = 1; i < str.length(); i++){
			if(str.charAt(i) == str.charAt(i - 1)){
				if(isShunKe(str.substring(0, i-1) + str.substring(i+1))){
					System.out.println("yes");
					return;
				}
			}
		}
		System.out.println("no");
	}
	
}
public static boolean isShunKe(String str){
	if(str.length() == 0){
		return true;
	}
	boolean flag = false;
	if(str.charAt(0) == str.charAt(1) && str.charAt(0) == str.charAt(2)){//ПЬзг
		flag = isShunKe(str.substring(3));
	}
	if(flag){//
		return true;
	}
	else {
		int i = 0;
		int j = i+1;
		while(i < 2 && j < str.length()){
		if(str.charAt(i) + 1 == str.charAt(j)){
			i++;
			str = switchStr(str, i, j);
			j++;
//			j = i+1;
		}
		else  {
			j++;
		}
		}
		if(i == 2){
			String newStr = str.substring(i + 1);
			String a = sort(newStr);
			flag = isShunKe(a);
		}
		
	}
	return flag;
}
public static String switchStr(String str, int a, int b){
	StringBuffer buffer = new StringBuffer();
	for(int i = 0; i < str.length(); i++){
		if(i == a){
			buffer.append(str.charAt(b));
		}
		else if(i == b){
			buffer.append(str.charAt(a));
		}
		else {
			buffer.append(str.charAt(i));
		}
	}
	
	return buffer.toString();
}
public static String sort(String str){
	String[] num = str.split("");
	
	Arrays.sort(num);
	StringBuffer buffer = new StringBuffer();
	for(int i = 0; i < num.length; i ++){
		buffer.append(num[i]);
//		System.out.println(num[i]);
	}
	return buffer.toString();
}

}
