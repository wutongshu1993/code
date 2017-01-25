package leeCode;
/**
 * 将字符串转化为整型,在字符转中遇见非数字则提前结束掉
 * 正负号，溢出，非法输入。
 * @author lh
 *
 */
public class StringToInteger {
public int myAtoi(String str) {
	
	int k = 0;
	int ret = 0;
    str = str.trim();
	if(str.length() == 0){
    	return 0;
    }
	if(str.charAt(0) == '+'){
		if(str.length() == 0){
			return 0;
		}
		return ParseInt(str.substring(1));
	}
    if(str.charAt(0) == '-'){
    	str = str.substring(1);
    	int i = str.length() - 1;
    	if(str.length() == 0){
    		return 0;
    	}
    	
    		while(i >= 0){
    			if(str.charAt(i) >= '0' && str.charAt(i) <= '9'){
    				ret -= (str.charAt(i) - '0') * Math.pow(10, k++);
    			}
    			else {
    				ret = 0;
    				k = 0;
    			}
    			i--;
    		}
    		return ret;
    }
	return ParseInt(str);
    }
/**
 * 将字符串转化为整型，在字符转中遇见非数字则提前结束掉
 * @param s
 * @return
 */
	public int ParseInt(String s){
		int i = s.length() - 1;
		int k = 0;
		int ret = 0;
		while(i >= 0){
			if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
				ret += (s.charAt(i) - '0') * Math.pow(10, k++);
			}
			else {
				ret = 0;
				k = 0;	
			}
			i--;
		}
		return ret;
	}

public static void main(String[] args){
	System.out.println(new StringToInteger().myAtoi("-1"));
}
}
