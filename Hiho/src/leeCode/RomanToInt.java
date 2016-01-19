package leeCode;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
public static int romanToInt(String s){
	int sum = 0;
	int temp;//���ڱ���ǰһ����
	Map<Character, Integer> values = new HashMap<>();
	values.put('I', 1);
	values.put('V', 5);
	values.put('X', 10);
	values.put('L', 50);
	values.put('C', 100);
	values.put('D', 500);
	values.put('M', 1000);
	char[] c = s.toCharArray();
	temp = values.get(c[0]);
	sum = temp;
	for(int i=1;i<c.length;i++){
		int cur = values.get(c[i]);
		if (cur <= temp) {//������VI�������������������Ӧ��ֵ���
			sum += cur;
		}
		else {
			sum = sum-temp+cur-temp;
		}
		temp = cur;
	}
	return sum;
}
public static void main(String[] args){
	System.out.println(romanToInt("MCMXCVI"));
}
}
