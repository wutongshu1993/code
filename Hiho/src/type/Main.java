package type;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
public static void main(String[] args){
	Scanner cin = new Scanner(System.in);
	Pattern p = Pattern.compile("^([A-Za-z]+(\\d+[a-zA-Z]*\\d*)+){8}");
	while(cin.hasNext()){
		int n = cin.nextInt();
		for(int i = 0; i < n; i++){
			String str = cin.nextLine();
			Matcher matcher = p.matcher(str);
			if(matcher.matches()){
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
		}
	}
}
}
