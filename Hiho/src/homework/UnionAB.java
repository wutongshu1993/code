package homework;

import java.util.ArrayList;

import sort.Merge;

/**
 * ����(A-B)����(B-A)
 * @author lh
 *
 */
public class UnionAB {
	/**
	 * �����Ѿ����������A,B������A-B
	 * @param a
	 * @param b
	 */
	public static ArrayList<Integer> unique(int[] a, int[] b){
		int[] c = new int[a.length];
		int i=0,j=0,ci=0;
		ArrayList<Integer> t = new ArrayList<>();
		while(i<a.length && j<b.length){
			if (a[i] < b[j]) {
				t.add(a[i++]);
//				c[ci++] = a[i];
//				i++;
			}
			else if (a[i]== b[j]) {
				i++;
				j++;
			}
			else if (a[i] > b[j]) {
				j++;
			}
		}
		while (j == b.length && i<a.length) {
			t.add(a[i++]);
//			c[ci++] = a[i++];
		}
		return t;
		//��
//		int[] temp = new int[ci];
//		for(int m=0;m<ci;m++)
//		{temp[m] = c[m];}
//		a = temp.clone();
//		for(int m=0;m<ci;m++)
//		{a[m] = c[m];}
//		a = c;//���c���鸳ֵ��a
		
	}
public static void main(String[] args){
	int[] a ={4,8,7,9,2,3,19};
	int[] b ={4,9,3,1,5};
	Merge.sort(a, 0, a.length-1);
	Merge.sort(b, 0, b.length-1);
//	System.out.println("**************");
//	for(int k=0;k<a.length;k++) System.out.print(a[k]+" ");
//	System.out.println("UnionAB.main()");
//	for(int k=0;k<b.length;k++) System.out.print(b[k]+" ");
	System.out.println("++++++++++");
//	int[] temp = a.clone();//����temp=aֻ��ʵ��ǳ����
	ArrayList<Integer> au = unique(a, b);
	ArrayList<Integer> bu = unique(b, a);
//	for(int k=0;k<au.size();k++) System.out.print(au.get(k)+" ");
//	System.out.println("UnionAB.main()2");
//	for(int k=0;k<bu.size();k++) System.out.print(bu.get(k)+" ");
	//�ϲ�A-B��B-A
	for (int i = 0; i < bu.size(); i++) {
		au.add(bu.get(i));
	}
	for (int i = 0; i < au.size(); i++) {
		System.out.print(au.get(i)+"  ");
	}

}
}
