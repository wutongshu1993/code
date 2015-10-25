package homework;

import java.util.ArrayList;

/**
 * 无逆序子序列的归并排序     
 * @author lh
 *
 */
public class Merge {
	static void Merge(int a[], int b[], int first, int mid, int last) // 合并两个有序序列
	{
		int p = first, q = mid + 1;
		int pos = first;
		while (p <= mid && q <= last) {
			if (a[p] < a[q]) {
				b[pos++] = a[p++];
			} else {
				b[pos++] = a[q++];
			}
		}
		if (p > mid) {
			while (q <= last) {
				b[pos++] = a[q++];
			}
		} else {
			while (p <= mid) {
				b[pos++] = a[p++];
			}
		}
	}
	/**
	 * 得出该数组的最长子序列的起始位置
	 * @param args
	 * @return
	 */
	static ArrayList<Integer>  getLongSeq(int[] args){
		ArrayList<Integer> seq = new ArrayList<>();//用于存储每个子序列开始的位置
		seq.add(0);//第一个非逆序子序列的起始位置是0
		for(int i=1;i<args.length;i++)
		{
			if (args[i-1] > args[i]) {//如果出现逆序
				seq.add(i);
			}
		}
		
		return seq;
	}
	/**
	 * 合并两个无逆序子序列
	 * @param a
	 * @param b
	 * @param seq
	 */
	static void mergeSeq(int[] a, int[] b, int[] seq){
		while(seq.length > 1){
		int i =0;
		int j;
		while(i+2<seq.length){
			Merge(a, b, seq[i], seq[i+1]-1, seq[i+2]-1);
			i = i+2;
		}
		//如果还剩最后两组没合并
		if (i+2==seq.length) {
			Merge(a, b, seq[i], seq[i+1]-1, a.length-1);
			i = i+2;
		}
		//将最后一组没有合并的合并
		if (i<seq.length) {
			for(int k=seq[i];k<a.length;k++){
				b[k] = a[k];
			}
		}
		//重新调整seq数组
		int temp[] = new int[(seq.length+1)/2];
		int m=0;
		int n=0;
		for( n=0;n<seq.length;n=n+2)
		{
			temp[m++] = seq[n];
		}
		//如果seq中的是单数
		if (n -1 > seq.length) {
			temp[m++] = seq[n-1];
		}
		seq = temp;
		mergeSeq(b, a, seq);
		}
		
	}
	
	static void merge_sort(int a[], int b[], int seq[]){
		
		while(seq.length > 1)
		{
			mergeSeq(a, b, seq);
			mergeSeq(b, a, seq);
		}
	}
	
	public static void main(String[] args){
		int[] a = {8,5,3,2,1,4,7,9};
		int[] b =new int [a.length];
		int[] seq = new int[getLongSeq(a).size()];
		for(int i=0;i<seq.length;i++)
		{
			seq[i] = getLongSeq(a).get(i);
		}
		mergeSeq(a, b, seq);
		for(int k =0;k<b.length;k++)
			System.out.print(b[k]+"  ");
//		for (int i : getLongSeq(a)) {
//			System.out.print(i+"   ");
//		}
	}
}
