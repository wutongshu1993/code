package homework;

import javax.swing.plaf.metal.OceanTheme;

/**
 * �޵ݹ飬����д
 * @author lh
 *
 */
public class MergeNoBack {
	/**
	 * �ϲ�������������
	 * @param a
	 * @param b
	 * @param first
	 * @param mid
	 * @param last
	 */
void merge(int a[], int b[], int first, int mid, int last){
	int p = first;
	int pos = first;
	int q = mid+1;
	while(p<=mid && q<last){
		if (a[p] < a[q]) {//����˳��ֱ�Ӹ��ƹ�ȥ
			b[pos++] = a[p++];
		}
		else {
			b[pos++] = a[q++];//
		}
	}
	if (p>mid) {
		while(q <= last){
			b[pos++] = a[q++];
		}
	}
	else {
		while(p<=mid)
		{
			b[pos++] = a[p++];
		}
	}
}
/**
 * ��һ�����������ݽ��кϲ�
 * @param a
 * @param b
 * @param gap
 * @param n
 */
void MergePass(int a[], int b[], int gap, int n){
	int i = 0;
	int j = 0;
	while(i <= n-2*gap+1 ){//
		merge(a, b, i, i+gap-1, i+2*gap-1);
		i = i+gap*2;
	}
	if (i<(n-gap)) {//�������ٺϲ�һ��
		merge(a, b, i, i+gap-1, n-1);
	}
	else {//ʣ�µĶ������ٺϲ��ˣ�ֱ�ӽ�aд��b
		for(j=i;j<n;j++)
			b[j] = a[j];
	}
}
void merge_sort(int a[],int b[],int n){
	int gap = 1;
	while(gap<n){
		MergePass(a, b, gap, n);
		gap = 2*gap;
		MergePass(b, a, gap, n);
		gap = 2*gap;
	}
}
}
