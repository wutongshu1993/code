package sort;
/**
 * ѡ��һ��Ԫ��Ϊ���ᣬ����С�ķ�ǰ�棬������ķź��档��������ָ�룬high��low�����high����ֵС��
 * ������ֵ������Ȼ���low��ʼ�����ѣ����ֵ������ֵ���򽻻���֪�����high��low���Ϊֹ��
 * @author lh
 *
 */
public class QuickSort {
private static int sort(int[] args, int low, int high ){
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

private static void Qsort(int args[], int low, int high){
	int pivotloc;
	if(low < high)
	{
		pivotloc = sort(args, low, high);//������һ��Ϊ��
		Qsort(args, low, pivotloc-1);//�Ե��ӱ�ݹ�����
		Qsort(args, pivotloc+1, high);//�Ը��ӱ�ݹ�����
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
