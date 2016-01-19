package sort;

import java.util.Stack;

/**
 * ѡ��һ��Ԫ��Ϊ���ᣬ����С�ķ�ǰ�棬������ķź��档��������ָ�룬high��low�����high����ֵС��
 * ������ֵ������Ȼ���low��ʼ�����ѣ����ֵ������ֵ���򽻻���֪�����high��low���Ϊֹ��
 * @author lh
 *
 */
public class QuickSort {
private static int partion(int[] args, int low, int high ){
	int pivokey = args[low];//��ʼ�ؼ���
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
 * �ݹ�ʵ��
 * @param args
 * @param low
 * @param high
 */
/*private static void Qsort(int args[], int low, int high){
	int pivotloc;
	if(low < high)
	{
		pivotloc = partion(args, low, high);//������һ��Ϊ��
		Qsort(args, low, pivotloc-1);//�Ե��ӱ�ݹ�����
		Qsort(args, pivotloc+1, high);//�Ը��ӱ�ݹ�����
	}
	if (low == high) {
		for(int i =0;i<args.length;i++)
			System.out.print(args[i]+" ");
		System.out.println();
	}
}
*/
/**
 * �ǵݹ�ʵ��
 * ��ʵ�����ֶ�����ջ���洢ÿ�ηֿ���ŵ���ʼ�㣬ջ�ǿ�ʱѭ����ȡ������ջ
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
