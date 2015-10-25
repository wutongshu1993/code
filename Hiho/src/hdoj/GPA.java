package hdoj;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GPA {
	//map的类型要和比较的数据的类型一致
public static Map<Character, Integer> table = new HashMap<>();
public static void main(String[] arg){
	table.put('A', 4);
	table.put('B', 3);
	table.put('C', 2);
	table.put('D', 1);
	table.put('F', 0);
	Scanner s = new Scanner(System.in);
	
	while(s.hasNextLine()){
		int sum = 0;
		int n = 0;
		float gpa = 0.f;
		String cString = s.nextLine();
		char[] result = cString.toCharArray();
		for(int i = 0;i<result.length;i++){
			char single = result[i];
			if(single == ' '){
				i++;
				
			}
			else if (table.get(single) == null) {
				
				System.out.println("Unknown letter grade in input");
				
			}
			else {
				sum+=table.get(single);
				i++;
				n++;
			}
			if (i == result.length) {
				gpa = (float)sum/n;
				System.out.println(new DecimalFormat("#.00").format(gpa));
			}
		}
		
		
	}

}
}
