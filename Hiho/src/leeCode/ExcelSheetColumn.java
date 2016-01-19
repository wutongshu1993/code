package leeCode;
//相当于26进制
public class ExcelSheetColumn {
public int titleToNumber(String s){
	if (s==null || s.equals("")) {
		return 0;
	}
	else {
		char[] c = s.toCharArray();
		int sum = 0;
		for(int i=c.length-1;i>=0;i--){
			int a = c[i] - 64;//
			int e = c.length-1-i;//26的幂
			sum += a*Math.pow(26, e);
		}
		return sum;
	}
	
}
}
