package leeCode;

public class AddString {
	/**
	 * 
	 * The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.输入的字符串的长度都小于5100，这样怎样保证不越界呢？？
	 * @param num1
	 * @param num2
	 * @return
	 */
public String addStrings(String num1, String num2) {
    long num1Int = 0;
    long num2Int = 0;
    int len1 = num1.length();
    int len2 = num2.length();
	for(int i = len1 - 1; i >= 0; i--){
    	long temp = (long)((num1.charAt(i) - '0') * Math.pow(10, len1 - 1 - i));
//		System.out.println(temp + num1Int);
    	num1Int += temp;
    }
	for(int i = len2 - 1; i >= 0; i--){
		long temp = (long)((num2.charAt(i) - '0') * Math.pow(10, len2 - 1 - i));
		num2Int += temp;
    }
	
	return num1Int + num2Int + ""; 
    }

/**
 * 由于字符串的长度有5100，所以这种超大数之间的运算只能用数组来存储，并模仿进位机制
 * @param num1
 * @param num2
 * @return
 */
public String addStrings2(String num1, String num2) {
    int len1 = num1.length();
    int len2 = num2.length();
    int [] ret = new int[Math.max(len1, len2) + 1];//万一产生进位呢
    int rt = ret.length - 1;
    int i = len1 - 1, j = len2 -1;
    int cp = 0;
    String res = "";
    int temp = 0;
    while(i >= 0 && j >= 0){
    	cp = 0;
    	temp =  ret[rt] + (num1.charAt(i) - '0') + (num2.charAt(j) - '0' );
    	cp = temp / 10;
    	ret[rt--] = temp % 10;
    	if(rt >= 0){
    		ret[rt] = cp;
    	}
    	i --;
    	j --;
    }
	while(i >= 0){
		cp = 0;
		temp = ret[rt] + (num1.charAt(i) - '0');
		cp = temp / 10;
    	ret[rt--] = temp % 10;
    	if(rt >= 0){
    		ret[rt] = cp;
    	}
    	
		i --;
	}
	while(j >= 0){
		cp = 0;
		temp = ret[rt] + (num2.charAt(j) - '0');
		cp = temp / 10;
    	ret[rt--] = temp % 10;
    	if(rt >= 0){
    		ret[rt] = cp;
    	}
		j --;
	}
	if(cp > 0){
		ret[rt] = cp;
	}
	
	for(int k = 1; k < ret.length; k++ ){
		res += ret[k];
	}
	if(ret[0] != 0){
		res = ret[0] + res;
	}
	return res; 
    }

public static void main(String[] arg){
//	System.out.println(new AddString().addStrings("9333852702227987","85731737104263"));
//	System.out.println(new AddString().addStrings2("23108814760092","55183904456427981"));
//	System.out.println(new AddString().addStrings2("231088","95183"));
	System.out.println(new AddString().addStrings2("9","2"));
}
}
