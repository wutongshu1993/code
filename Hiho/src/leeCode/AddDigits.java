package leeCode;

public class AddDigits {
public static int printDigits(int n){
	while(n>=0){
		String s = String.valueOf(n);
		char[] c = s.toCharArray();
		int sum=0;
		if (c.length > 1) {
			for(int i=0;i<c.length;i++){
				sum += Integer.parseInt(c[i]+"");
			}
			n = sum;
		}
		else {
			return n;
		}
		
	}
	return n;
}
public static void main(String[] args){
	System.out.println(printDigits(38));
}
}
