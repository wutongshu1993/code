package leeCode;
/**
 * ���ַ���ת��Ϊ����,���ַ�ת����������������ǰ������
 * �����ţ�������Ƿ����롣
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
 * ���ַ���ת��Ϊ���ͣ����ַ�ת����������������ǰ������
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
