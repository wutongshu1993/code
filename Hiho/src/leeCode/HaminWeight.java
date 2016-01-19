package leeCode;

import java.util.ArrayList;
import java.util.List;
/**
 * 有一个问题是，java的int类型默认是有符号的，题目中的int是无符号的，
 * 所以需要处理溢出了的情况，
 * if (n<0) {//溢出了
		m++;
		n = n& Integer.MAX_VALUE;
	}
	或者是采用n & (n-1);
如将1(整数类型)转化为Long.
1.int转化为String.
String str = String.valueOf(1);
2.String转化为Long.
Long l = Long.parseLong(str);
即：Long l = Long.parseLong(String.valueOf(1));
 * @author lh
 *
 */
public class HaminWeight {
public static int haminWeight(int n){
	//相当于把整数转化为二进制
	
	int m=0;//1的个数
	List<Integer> num = new ArrayList<>();//用于存放余数
	if (n<0) {//溢出了
		m++;
		n = n& Integer.MAX_VALUE;
		
	}
	while (n > 1) {
		num.add(n%2);
		n=n/2;
	}
	if (n == 1) {
		num.add(1);
	}
	for(long i : num){
		if (i==1) {
			m++;
		}
	}
	
	return m;
}
/**
 * 将
 * @param n
 * @return
 */
public static void toUnsignedLong(int n){
	
}
public static void main(String[] args){
 System.out.println((-8>>1));//这是算术左移，要管符号位；逻辑左移不管符号位>>>
}
}
