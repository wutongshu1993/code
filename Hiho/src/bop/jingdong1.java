package bop;


import java.util.Arrays;
import java.util.Scanner;
/**
 * 公司最近新研发了一种产品，共生产了n件。有m个客户想购买此产品，第i个客户出价Vi元。
 * 为了确保公平，公司决定要以一个固定的价格出售产品。
 * 每一个出价不低于要价的客户将会得到产品，余下的将会被拒绝购买。请你找出能让公司利润最大化的售价。
 * @author lh
 *
 */
public class jingdong1 {
public static void main(String[] args){
	Scanner s = new Scanner(System.in);
	while(s.hasNext()){
		int n = s.nextInt();//商品数
		int m = s.nextInt();//客户数
		int[] v = new int[m];
		for(int i = 0; i < m; i++){
			v[i] = s.nextInt();
		}
		//开始处理
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
	int[] p = new int[len];//p[i]表示用定价v[i]的收益
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
