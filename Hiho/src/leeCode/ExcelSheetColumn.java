package leeCode;
//�൱��26����
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
			int e = c.length-1-i;//26����
			sum += a*Math.pow(26, e);
		}
		return sum;
	}
	
}
}
