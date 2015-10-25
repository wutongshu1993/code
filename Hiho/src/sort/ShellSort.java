package sort;

public class ShellSort {
	/**
	 * 希尔排序是一种特殊的直接插入排序，只是增量不是1
	 * @param args 被排序的数组
	 * @param dk 希尔排序的增量
	 */
private static void sort(int[] args, int dk){
	int temp;
	for(int i=dk;i<args.length;i++){
		if (args[i] < args[i-dk]) {//如果后面<前面
			temp = args[i];
			args[i] = args[i-dk];
			args[i-dk] = temp;
		}
	}
}
public static void main(String[] args){
	int[] dk = {4,3,1};
	int[] data = {49,38,65,97,76,13,27,49};
	for(int i=0;i<dk.length;i++)
		sort(data, dk[i]);
	for (int i = 0; i < data.length; i++) {
		System.out.print(data[i] +" ");
	}
}
}
