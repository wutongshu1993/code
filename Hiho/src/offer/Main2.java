package offer;

import java.util.Scanner;

/**
 * ����һ���ַ��������ַ����еĴ�д��ĸ�Ƶ����ȥ�����ı�������ĸ�����˳�������λ����ַ������磺
 * ��һ���ַ����Ĵ�д��ĸ�ŵ��ַ����ĺ��棬�����ַ������λ�ò��䣬�Ҳ����������Ŀռ䡣
���ܰ��СQ��AkleBiCeilD��� kleieilABCD
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
