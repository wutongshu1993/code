package sort;

//import org.omg.CORBA.ARG_IN;

import util.ArrayUtils;

public class BubbleSort {
private static void sort(int[] arg){
	int temp;
	for(int i=0;i<arg.length;i++){
		for(int j=1;j<arg.length-i;j++){
			if (arg[j-1] > arg[j]) {
				temp = arg[j-1];
				arg[j-1] = arg[j];
				arg[j] = temp;
				
			}
		}
	}
	for(int i =0;i<arg.length;i++)
		System.out.print(arg[i]+" ");
}
//�Ż��������
private static void sort2(int[] arg){
	int temp;
	boolean flag = true;
	int k = arg.length;
	while(flag){
		flag = false;
		for(int j=1; j<k;j++){
		if (arg[j] > arg[j-1]) {
			flag = true;
			temp = arg[j-1];
			arg[j-1] = arg[j];
			arg[j] = temp;
		}
		k--;
		}
	}
	for(int i=0;i<arg.length;i++){
		for(int j=1;j<arg.length-i;j++){
			if (arg[j-1] > arg[j]) {
				temp = arg[j-1];
				arg[j-1] = arg[j];
				arg[j] = temp;
				
			}
		}
	}
	for(int i =0;i<arg.length;i++)
		System.out.print(arg[i]+" ");
}
/**
 * �Ľ����ð������,ð�������һ�η���������λ��firstChange֮ǰ����������ģ�
 * ���һ�η���������λ��lastChange֮������������
 * ��������Ļ���firstChange-1��λ�ú�lastChange������
 * @param arg
 */
static void bubbleSort(int arg[]){
	int numpairs,firstChange,lastChange;
	boolean didSwitch;
	firstChange = 1;
	didSwitch = true;
	numpairs = arg.length -1;
	lastChange = arg.length -1;
	while(didSwitch){
		didSwitch = false;
		for(int j=firstChange-1;j<lastChange;j++){
			if (arg[j] > arg[j+1]) {
				ArrayUtils.swap(arg, j, j+1);
				if (!didSwitch) {//��¼��һ�η��������ĵط�
					firstChange = j;
				}
				didSwitch = true;
				numpairs = j;//�����������λ��
			}
		}
		lastChange = numpairs;
		if (firstChange < 1) {
			firstChange = 1;
		}
	}
	ArrayUtils.printArray(arg);
}
public static void main(String[] arg){
	int[] a = {49,38,65,97,76,13,27,49};
	//sort2(a);
	bubbleSort(a);
}
}
