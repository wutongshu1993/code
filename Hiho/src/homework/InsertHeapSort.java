package homework;

import sort.HeapSort;

/**
 * 插入法建大顶堆，进行堆排序
 * @author lh
 *
 */
public class InsertHeapSort {
	/**
	 * 自下向上进行调整，调整到根元素为止
	 * @param args
	 */
	static void buildHeap(int[] args){
//第一个插入的肯定有序，所以从第二个元素开始取
	for(int i = 2; i < args.length;i++){
		int j = i;
		int flag = 1;
		while(flag==1 && j!=1){
//			int k = j/2;
			int k;
			k = j/2;
			//将该节点的值和它的父节点进行比较，如果插入的元素更大，则交换
			if (args[j] > args[k]) {
				util.ArrayUtils.swap(args, j, k);
			}
			else {
				//插入后没有影响堆，则不用向上进行调整
				 flag =0;
			}
			j = k;
		}
	}
}
/**
 * 当把堆尾元素和根元素互换后，需要调用该函数进行调整，
 * 从当前位置开始是调整，直到到末尾为止
 * @param args
 * @param s 从当前位置
 * @param m 末尾位置
 */
	static void heapAjust(int[] args, int s, int m){
	int j;
	args[0] = args[s];
	for(j=2*s; j<=m; j=j*2){
		//如果调整以后，当前位置的值 仍然大于其子孩子的值，则不需要进行下去了
		if (j<m && args[j+1] >= args[j]) {
			j++;//取子孩子中较大的元素
		}
		if (args[0] >= args[j]) {//如果大于子孩子中较大的元素，则不变
			break;
		}
//		util.ArrayUtils.swap(args, s, j);
		args[s] = args[j];
		s = j;
		args[s] = args[0];
		
	}
}
/**
 * 将根元素和最后一个元素互换位置，输出末尾元素，i--；
 * 再从根节点开始向下调整
 * @param args
 */
static void heapSort(int[] args){
	if (args==null || args.length <= 1) {
		return ;
	}
	buildHeap(args);
	for(int i = args.length-1; i>=1; --i){
		util.ArrayUtils.swap(args, 1, i);
		heapAjust(args, 1, i-1);
	}
}
public static void main(String[] args){
	int[] a = {0,49,38,65,97,76,13,27,49};
	heapSort(a);
	util.ArrayUtils.printArray(a);
}
}
