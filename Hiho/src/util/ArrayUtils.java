package util;

public class ArrayUtils {
	/**
	 * ��������е�Ԫ��
	 * @param array
	 */
public static void printArray(int[] array){
	for(int i =0;i<array.length;i++){
		System.out.print(array[i]+" ");
	}
}
/**
 * ����������ָ��λ�õ�����
 * 
 */
public static void swap(int[] arg, int i,int k){
	int temp;
	temp = arg[i];
	arg[i] = arg[k];
	arg[k] = temp;
}
}
