package bop;

import java.util.Scanner;

import javax.lang.model.element.VariableElement;

public class toutiao1 {
public static void main(String[] args){
	Scanner s = new Scanner(System.in);
	while(s.hasNext()){
		int n = s.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++){
			arr[i] = s.nextInt();
		}
		//��ʼ����
		int[] ups = getUp(arr);
		int[] downs = getDowns(arr);
		int[] res = getLong(ups, downs);
		System.out.println(res[0] + " " + res[1]);
	}
}
//�ҳ�Ԫ���󲿵������������
public  static int[] getUp(int[] arr){
	int[] ups = new int[arr.length];
	ups[0] = 0;
	for(int i = 1; i < arr.length; i++){
		int count = 0;
		if(arr[i] > arr[i-1]){
			ups[i] = ups[i-1] + 1;
		}
		else {
			ups[i] = 0;
		}
	}
	return ups;
}

// �ҳ�Ԫ���ұߵ���½�������
public  static int[] getDowns(int[] arr){
	int[] downs = new int[arr.length];
	downs[arr.length - 1] = 0;
	
	for(int i = arr.length - 2; i >= 0; i--){
		if(arr[i] > arr[i+1]){
			downs[i] = downs[i+1] + 1;
		}
		else {
			downs[i] = 0;
		}
	}
	
	return downs;
}

// 
public static int[] getLong(int[] ups, int[] downs){
	int max = 0;
	int l = -1;
	int r = -1;
	int[] res = new int[2];
	if(ups.length == 0 || downs.length == 0){
		res[0] = l;
		res[1] = r;
		return res;
	}
	for(int i = 0; i < ups.length; i++){
		if((ups[i] + downs[i]) > max){
			max = ups[i] + downs[i];
			l = i - ups[i];
			r = i + downs[i];
		}
	}
	res[0] = l;
	res[1] = r;
	return res;
}
}
