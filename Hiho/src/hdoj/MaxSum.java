package hdoj;

import java.util.ArrayList;
import java.util.Scanner;

public class MaxSum {
private static  int n;//输入的序列数
private static ArrayList<Integer> a = new ArrayList<>();
public static void main(String[] arg){
	Scanner s = new Scanner(System.in);
	n = s.nextInt();
	int i=0;
	while(n-- > 0){
		int m = s.nextInt();//这个序列包含几个数字
		while(m-- > 0){
			a.add(s.nextInt());
		}
		System.out.println("Case "+ ++i+":");
		//比较子序列
		compare(a);
		System.out.println( );
		a.clear();
	}
	s.close();
}
/**
 * 算法关键思想，在于设一个临时最大值和最大值，对于临时最大值，当当前值小于0时，
 * 可以重新计算，并和之前的最大值进行比较（借鉴最大子字符串的思想）
 * @param a
 */
private static void compare(ArrayList<Integer> a){
	int sum = -2000;//子序列和最大值(如果全是负数，)
	int from = 0;//最大子序列的起始位置
	int end = 0;//最大子序列的结束位置
	int temp_sum=0;//临时最大值
	int cur = 0;
	for(int i=0;i<a.size();i++){
		if (temp_sum < 0) {
			temp_sum = a.get(i);
			cur = i;
		}
		else {
			temp_sum += a.get(i);
		}
		if (temp_sum > sum) {
			sum = temp_sum;
			from = cur;
			end = i;
		}
//		if (cur > end) {
//			from = end;
//		}
	}
	System.out.println(sum+" "+(from+1)+" "+(end+1));
	
	
	
}
}
