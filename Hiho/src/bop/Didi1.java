package bop;

import java.text.DecimalFormat;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;

import hiho.Dfs;

public class Didi1 {
	public static void main(String[] args){
	Scanner in = new Scanner(System.in);
	while(in.hasNext()){
		double r = in.nextDouble();
		int n = in.nextInt();
		String sr = r + "";
		int index = sr.indexOf(".");
		int len = sr.length() - index + 1;
		len = len * n;
		double res = 1;
		for(int i = 0; i < n; i++){
			res = res *r;
			res = Double.parseDouble(String.format("%."+len+"f", res));
		}
//		res = Math.pow(r, n);
//		System.out.println(res);
		System.out.println(String.format("%."+len+"f", res));
		
	}
}
}
