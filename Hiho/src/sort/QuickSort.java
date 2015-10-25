package sort;
/**
 * 选第一个元素为枢轴，比它小的放前面，比它大的放后面。采用两个指针，high和low，如果high比轴值小，
 * 则与轴值交换，然后从low开始往后搜，如果值大于轴值，则交换，知道最后high和low相等为止。
 * @author lh
 *
 */
public class QuickSort {
private static int sort(int[] args, int low, int high ){
	int pivokey = args[low];//初始关键字
	while(low < high){
		while (args[high] >= pivokey && low < high) 
			high--;
		args[low] = args[high];
		while(args[low] <= pivokey && low < high)
			low++;
		args[high] = args[low];
	}
	args[low] = pivokey;
	return low;
}

private static void Qsort(int args[], int low, int high){
	int pivotloc;
	if(low < high)
	{
		pivotloc = sort(args, low, high);//将数组一分为二
		Qsort(args, low, pivotloc-1);//对低子表递归排序
		Qsort(args, pivotloc+1, high);//对高子表递归排序
	}
	if (low == high) {
		for(int i =0;i<args.length;i++)
			System.out.print(args[i]+" ");
		System.out.println();
	}
}

public static void main(String[] args){
	int[] a = {49,38,65,97,76,13,27,49};
	Qsort(a, 0, a.length-1);
}
}
