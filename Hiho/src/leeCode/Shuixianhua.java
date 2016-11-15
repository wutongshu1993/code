package leeCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Shuixianhua {
public static void main(String[] args){
	Scanner scanner = new Scanner(System.in);
	int a, b;
	while(scanner.hasNext()){
		 a = scanner.nextInt();
		 b = scanner.nextInt();
		 PrintShuiXH(a, b);
	}
}

public static void PrintShuiXH(int a, int b){
	String ret = "";
	boolean flag = false;
	for(int i = a; i <= b; i++){
		int temp = 0;
		int val = i;
		for(int j = 0; j < 3; j++){//三位数是固定的
			temp += Math.pow(val % 10, 3);
			val = val / 10;
		}
		if (temp == i) {
			flag = true;
			ret += i + " ";
			
		}
	}
	if(flag){
		String t = ret.substring(0, ret.length() -1);
		System.err.println(t.length() + ":" + ret.length());
		System.out.println(ret.substring(0, ret.length() -1));
	}
	if(!flag){
		System.err.println("no");
	}
	return;
}
	
}
