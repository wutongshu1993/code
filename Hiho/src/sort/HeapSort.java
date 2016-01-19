package sort;

import util.ArrayUtils;
/**
 * ������
 * @author lh
 *
 */
public class HeapSort {
	/**
	 * ����ǰ�ڵ�������ӽڵ����Ϊ�󶥶�
	 * ��index�ڵ㿪ʼ�����������ε��������ӽڵ�
	 * @param array ��Ҫ����������
	 * @param heapSize
	 * @param index ��Ҫ��������ʼλ��
	 */
	public static void maxHeap(int[] array, int heapSize, int index) {
		int left = 2 * index + 1;// index������
		int right = 2 * index + 2;// �Һ���

		int largest = index;
		if (left < heapSize && array[index] < array[left]) {
			largest = left;
		}
		if (right < heapSize && array[largest] < array[right]) {
			largest = right;
		}
		if (index != largest) {
			ArrayUtils.swap(array, index, largest);
			maxHeap(array, heapSize, largest);//��Ԫ�غ����ĺ��ӵ���λ���Ժ󣬼�����������
		}
	}
/**
 * �ӵ�һ����Ҷ�ӽڵ㿪ʼ������Ϊ�󶥶�
 * @param array
 */
public static void buildMaxHeap(int[] array){
	if (array == null || array.length <= 1) {
		return;
	}
	int half = array.length  / 2 ;
	for(int i=half;i>=0;i--){//�ӵ�һ����Ҷ�ӽڵ㿪ʼ���ϵ����������ε���������Ҷ�ӽڵ㣨�������ϣ��������ҵ�����
		maxHeap(array, array.length, i);
	}
}
/**
 * �����Ԫ��ȡ������������
 * @param array
 */
public static void heapSort(int[] array){
	if (array == null || array.length <= 1) {
		return;
	}
	buildMaxHeap(array);
	for(int i = array.length-1;i>=1;i-- ){
		ArrayUtils.swap(array, 0, i);//�����һ��Ԫ�غͶѶ�Ԫ�ػ���
		maxHeap(array, i, 0);//�ӶѶ���ʼ�����µ���
	}
}
public static void main(String[] args){
	int[] a = {49,38,65,97,76,13,27,49};
	heapSort(a);
	ArrayUtils.printArray(a);
}
}
