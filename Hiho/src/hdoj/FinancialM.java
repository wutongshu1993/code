package hdoj;

import java.text.DecimalFormat;
import java.util.Scanner;

public class FinancialM {
public static void main(String[] arg){
	Scanner s = new Scanner(System.in);
	float sum = 0.f;
	for (int i = 0; i < 12; i++) {
		sum += s.nextFloat();
	}
	float avg = sum / 12;
	DecimalFormat df = new DecimalFormat("#.00");//保留到小数点后两位
	System.out.println("$"+df.format(avg));
	
}
}
