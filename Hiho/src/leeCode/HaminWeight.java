package leeCode;

import java.util.ArrayList;
import java.util.List;
/**
 * ��һ�������ǣ�java��int����Ĭ�����з��ŵģ���Ŀ�е�int���޷��ŵģ�
 * ������Ҫ��������˵������
 * if (n<0) {//�����
		m++;
		n = n& Integer.MAX_VALUE;
	}
	�����ǲ���n & (n-1);
�罫1(��������)ת��ΪLong.
1.intת��ΪString.
String str = String.valueOf(1);
2.Stringת��ΪLong.
Long l = Long.parseLong(str);
����Long l = Long.parseLong(String.valueOf(1));
 * @author lh
 *
 */
public class HaminWeight {
public static int haminWeight(int n){
	//�൱�ڰ�����ת��Ϊ������
	
	int m=0;//1�ĸ���
	List<Integer> num = new ArrayList<>();//���ڴ������
	if (n<0) {//�����
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
 * ��
 * @param n
 * @return
 */
public static void toUnsignedLong(int n){
	
}
public static void main(String[] args){
 System.out.println((-8>>1));//�����������ƣ�Ҫ�ܷ���λ���߼����Ʋ��ܷ���λ>>>
}
}
