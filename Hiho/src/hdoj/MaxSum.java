package hdoj;

import java.util.ArrayList;
import java.util.Scanner;

public class MaxSum {
private static  int n;//�����������
private static ArrayList<Integer> a = new ArrayList<>();
public static void main(String[] arg){
	Scanner s = new Scanner(System.in);
	n = s.nextInt();
	int i=0;
	while(n-- > 0){
		int m = s.nextInt();//������а�����������
		while(m-- > 0){
			a.add(s.nextInt());
		}
		System.out.println("Case "+ ++i+":");
		//�Ƚ�������
		compare(a);
		System.out.println( );
		a.clear();
	}
	s.close();
}
/**
 * �㷨�ؼ�˼�룬������һ����ʱ���ֵ�����ֵ��������ʱ���ֵ������ǰֵС��0ʱ��
 * �������¼��㣬����֮ǰ�����ֵ���бȽϣ����������ַ�����˼�룩
 * @param a
 */
private static void compare(ArrayList<Integer> a){
	int sum = -2000;//�����к����ֵ(���ȫ�Ǹ�����)
	int from = 0;//��������е���ʼλ��
	int end = 0;//��������еĽ���λ��
	int temp_sum=0;//��ʱ���ֵ
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
