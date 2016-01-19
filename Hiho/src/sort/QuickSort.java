package sort;

import java.util.Stack;

/**
 * 选第一个元素为枢轴，比它小的放前面，比它大的放后面。采用两个指针，high和low，如果high比轴值小，
 * 则与轴值交换，然后从low开始往后搜，如果值大于轴值，则交换，知道最后high和low相等为止。
 * @author lh
 *
 */
public class QuickSort {
private static int partion(int[] args, int low, int high ){
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
/**
 * 递归实现
 * @param args
 * @param low
 * @param high
 */
/*private static void Qsort(int args[], int low, int high){
	int pivotloc;
	if(low < high)
	{
		pivotloc = partion(args, low, high);//将数组一分为二
		Qsort(args, low, pivotloc-1);//对低子表递归排序
		Qsort(args, pivotloc+1, high);//对高子表递归排序
	}
	if (low == high) {
		for(int i =0;i<args.length;i++)
			System.out.print(args[i]+" ");
		System.out.println();
	}
}
*/
/**
 * 非递归实现
 * 其实就是手动利用栈来存储每次分块快排的起始点，栈非空时循环获取中轴入栈
 * @param arr
 * @param low
 * @param high
 */
public static void Qsort(int arr[],int low,int high) {
    Stack<Integer> st = new Stack<Integer>();
    if (low < high) {
        int mid = partion(arr, low, high);
        if (mid-1 > low) {
            st.push(mid-1);
            st.push(low);
        }
        if (mid+1 < high) {
            st.push(high);
            st.push(mid+1);
        }

        while (!st.isEmpty()) {
            int q_low = st.peek();
            st.pop();
            int p_high = st.peek();
            st.pop();
            mid = partion(arr, q_low, p_high);
            if (mid-1 > q_low) {
                st.push(mid-1);
                st.push(q_low);
            }
            if (mid+1 < p_high) {
                st.push(p_high);
                st.push(mid+1);
            }
        }

    }
}

public static void main(String[] args){
	int[] a = {49,38,65,97,76,13,27,49};
	Qsort(a, 0, a.length-1);
}
}
