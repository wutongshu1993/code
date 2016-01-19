package sort;

import util.ArrayUtils;
/**
 * 堆排序，
 * @author lh
 *
 */
public class HeapSort {
	/**
	 * 将当前节点和它的子节点调整为大顶堆
	 * 从index节点开始调整，再依次调整它的子节点
	 * @param array 需要调整的数组
	 * @param heapSize
	 * @param index 需要调整的起始位置
	 */
	public static void maxHeap(int[] array, int heapSize, int index) {
		int left = 2 * index + 1;// index的左孩子
		int right = 2 * index + 2;// 右孩子

		int largest = index;
		if (left < heapSize && array[index] < array[left]) {
			largest = left;
		}
		if (right < heapSize && array[largest] < array[right]) {
			largest = right;
		}
		if (index != largest) {
			ArrayUtils.swap(array, index, largest);
			maxHeap(array, heapSize, largest);//将元素和它的孩子调换位置以后，继续调整孩子
		}
	}
/**
 * 从第一个非叶子节点开始，调整为大顶堆
 * @param array
 */
public static void buildMaxHeap(int[] array){
	if (array == null || array.length <= 1) {
		return;
	}
	int half = array.length  / 2 ;
	for(int i=half;i>=0;i--){//从第一个非叶子节点开始向上调整，再依次调整各个非叶子节点（自下向上，自左向右调整）
		maxHeap(array, array.length, i);
	}
}
/**
 * 将最大元素取出，继续排序
 * @param array
 */
public static void heapSort(int[] array){
	if (array == null || array.length <= 1) {
		return;
	}
	buildMaxHeap(array);
	for(int i = array.length-1;i>=1;i-- ){
		ArrayUtils.swap(array, 0, i);//将最后一个元素和堆顶元素互换
		maxHeap(array, i, 0);//从堆顶开始，重新调整
	}
}
public static void main(String[] args){
	int[] a = {49,38,65,97,76,13,27,49};
	heapSort(a);
	ArrayUtils.printArray(a);
}
}
