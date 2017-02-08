package offer;

import java.util.Scanner;

/**
 * 输入一个字符串，将字符串中的大写字母移到后边去，不改变其余字母的相对顺序。输出移位后的字符串，如：
 * 把一个字符串的大写字母放到字符串的后面，各个字符的相对位置不变，且不能申请额外的空间。
你能帮帮小Q吗？AkleBiCeilD输出 kleieilABCD
 * @author Administrator
 *
 */
public class Main2 {
public static void main(String[] args){
	Scanner scanner = new Scanner(System.in);
	while(scanner.hasNext()){
		String str = scanner.nextLine();
		getResult(str);
	}
	scanner.close();
}
public static void getResult(String str){
	int len = str.length();
	String str1 = "";
	String str2 = "";
	for(int i = 0; i < len; i++){
		if(str.charAt(i) - 'a' >= 0){
			str1 += str.charAt(i);
		}
		else {
			str2 += str.charAt(i);
		}
	}
	System.out.println(str1+str2);
}
}
