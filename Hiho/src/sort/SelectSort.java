package sort;
/**
 * 将元素一次到位
 * @author lh
 *
 */
public class SelectSort {
	/**
	 * 选取i~args.length中最小的元素
	 * @param args
	 * @param k
	 * @return
	 */
	public static int selectMinKey(int[] args, int k){
		int min=k;
		for(int i=k;i<args.length;i++)
			if (args[min] > args[i]) {
				min = i;
			}
		return min;
	}
private static void sort(int args[]){
	int j,temp;
	for(int i=0; i<args.length;i++)
	{
		j = selectMinKey(args,i);//选择最小的元素
		if (i != j) {
			temp = args[i] ;
			args[i] = args[j];
			args[j] = temp;
		}
	}
	for(int i=0;i<args.length;i++)
	System.out.print(args[i]+" ");
}
public static void main(String[] arg){
	int[] a = {49,38,65,97,76,13,27,49};
	sort(a);
}
}
