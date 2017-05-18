package bop;


import java.util.Arrays;
import java.util.Scanner;
/**
 * ��˾������з���һ�ֲ�Ʒ����������n������m���ͻ��빺��˲�Ʒ����i���ͻ�����ViԪ��
 * Ϊ��ȷ����ƽ����˾����Ҫ��һ���̶��ļ۸���۲�Ʒ��
 * ÿһ�����۲�����Ҫ�۵Ŀͻ�����õ���Ʒ�����µĽ��ᱻ�ܾ����������ҳ����ù�˾������󻯵��ۼۡ�
 * @author lh
 *
 */
public class jingdong1 {
public static void main(String[] args){
	Scanner s = new Scanner(System.in);
	while(s.hasNext()){
		int n = s.nextInt();//��Ʒ��
		int m = s.nextInt();//�ͻ���
		int[] v = new int[m];
		for(int i = 0; i < m; i++){
			v[i] = s.nextInt();
		}
		//��ʼ����
		Arrays.sort(v);
		int res;
		if(n == 1){
			res = v[m-1];
			System.out.println(res);
			return;
		}
		res = getMax(n, v);
		System.out.println(res);
	}
}
public static int getMax(int n, int[] vi){
	int len = vi.length;
	int[] p = new int[len];//p[i]��ʾ�ö���v[i]������
	int max = 0;
	int witch = 0;
	p[0] = vi[0] * len;
	max = p[0];
	for(int i = 1; i < len; i++){
		int num = Math.min(n, len-i);
		p[i] = vi[i] * num;
		for(int j = i-1; j >= 0; j--){
			if(vi[j] == vi[i]){
				p[i] += vi[j];
			}
			else {
				break;
			}
		}
		if(p[i] > max){
			max = p[i];
			witch = i;
		}
//		System.out.println(p[i]);
	}
	return vi[witch];
}
}
