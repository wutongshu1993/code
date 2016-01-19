package homework;

import sort.HeapSort;

/**
 * ���뷨���󶥶ѣ����ж�����
 * @author lh
 *
 */
public class InsertHeapSort {
	/**
	 * �������Ͻ��е�������������Ԫ��Ϊֹ
	 * @param args
	 */
	static void buildHeap(int[] args){
//��һ������Ŀ϶��������Դӵڶ���Ԫ�ؿ�ʼȡ
	for(int i = 2; i < args.length;i++){
		int j = i;
		int flag = 1;
		while(flag==1 && j!=1){
//			int k = j/2;
			int k;
			k = j/2;
			//���ýڵ��ֵ�����ĸ��ڵ���бȽϣ���������Ԫ�ظ����򽻻�
			if (args[j] > args[k]) {
				util.ArrayUtils.swap(args, j, k);
			}
			else {
				//�����û��Ӱ��ѣ��������Ͻ��е���
				 flag =0;
			}
			j = k;
		}
	}
}
/**
 * ���Ѷ�βԪ�غ͸�Ԫ�ػ�������Ҫ���øú������е�����
 * �ӵ�ǰλ�ÿ�ʼ�ǵ�����ֱ����ĩβΪֹ
 * @param args
 * @param s �ӵ�ǰλ��
 * @param m ĩβλ��
 */
	static void heapAjust(int[] args, int s, int m){
	int j;
	args[0] = args[s];
	for(j=2*s; j<=m; j=j*2){
		//��������Ժ󣬵�ǰλ�õ�ֵ ��Ȼ�������Ӻ��ӵ�ֵ������Ҫ������ȥ��
		if (j<m && args[j+1] >= args[j]) {
			j++;//ȡ�Ӻ����нϴ��Ԫ��
		}
		if (args[0] >= args[j]) {//��������Ӻ����нϴ��Ԫ�أ��򲻱�
			break;
		}
//		util.ArrayUtils.swap(args, s, j);
		args[s] = args[j];
		s = j;
		args[s] = args[0];
		
	}
}
/**
 * ����Ԫ�غ����һ��Ԫ�ػ���λ�ã����ĩβԪ�أ�i--��
 * �ٴӸ��ڵ㿪ʼ���µ���
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
