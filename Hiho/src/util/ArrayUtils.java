package util;

public class ArrayUtils {
	/**
	 * 输出数组中的元素
	 * @param array
	 */
public static void printArray(int[] array){
	for(int i =0;i<array.length;i++){
		System.out.print(array[i]+" ");
	}
}
/**
 * 交换数组中指定位置的数据
 * 
 */
public static void swap(int[] arg, int i,int k){
	int temp;
	temp = arg[i];
	arg[i] = arg[k];
	arg[k] = temp;
}
}
