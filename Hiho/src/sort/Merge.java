package sort;

import javax.swing.text.GapContent;

import util.ArrayUtils;

/**
 * 归并排序
 * @author lh
 *
 */
public class Merge {
	/**
	 * 将args[i...m]和args[m+1...n]归并为temp[i...n]
	 * @param args
	 * @param temp
	 * @param i
	 * @param m
	 * @param n
	 */
public static void merge(int[] args,int i,int m, int n){
	int index = i;
	int j = i;
	int k = m+1;
	int[] temp = new int[args.length];//临时数组
	int tmp = i;
	while(j<=m && k<=n){
		if (args[j] < args[k]) {
			temp[index++] = args[j];
			j++;
		}
		else {
			temp[index++] = args[k];
			k++;
		}
	}
	if (j>m) {
		for(int from=k; from<=n; from++)
			temp[index++] = args[from];
	}
	if (k>n) {
		for(int from=j; from<=m; from++)
			temp[index++] = args[from];
	}
	//将temp赋值给array
	while(tmp<=n){
		args[tmp] = temp[tmp++];
	}
}


public static void sort(int[] args, int left, int right){
	if (left >= right) {
		return;
	}
	int center = (left+right) /2;
	sort(args, left, center);
	sort(args, center+1, right);
	merge(args, left, center, right);
	ArrayUtils.printArray(args);
	System.out.println();
}
public static void main(String[] args){
	int[] a = {49,38,65,97,76,13,27,49};
	sort(a, 0, a.length-1);
//	mergeSort(a);
	ArrayUtils.printArray(a);
}
}
