package leeCode;

import java.text.DecimalFormat;
import java.util.Scanner;

public class ArraySum {
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	while(scanner.hasNext()){
		int m = scanner.nextInt();
		int n = scanner.nextInt();
		getSum(m, n);
	}
}

public static void getSum(double m, int n){
	
	DecimalFormat    df   = new DecimalFormat(".00");   
	float sum = 0.f;
	for(int i = 0; i < n; i++){
		sum += m;
		m = Math.sqrt(m);
	}
	System.out.println(df.format(sum));
}
}
