package bop;

import java.util.Arrays;
import java.util.Scanner;

public class wanmei1 {
	public static int count = 0;
public static void main(String[] args){
	Scanner s = new Scanner(System.in);
	while(s.hasNext()){
		//处理数据
		String str = s.nextLine();
		String[] strs = str.split(",");
		int[] arr = new int[strs.length];
		for(int i = 0; i < arr.length;i++){
			arr[i] = Integer.parseInt(strs[i]);
		}
		int total = s.nextInt();
		Arrays.sort(arr);
		//数据处理完毕
		if(getNum(arr, total, arr.length - 1)){
			System.out.println(count);
		}
		else {
			System.out.println("-1");
		}
		
	}
}
public static boolean getNum(int[] arr, int total, int i){
	if(total == 0){
		return true;
	}
	if(total< 0 || i < 0){
		return false;
	}
	if(arr[i] == 0 && total > 0){
		return false;
	}

	int n = total / arr[i];
	count = count + n;
	int newVal = total - n * arr[i];
	boolean flag = getNum(arr, newVal, i-1);
	if(flag){
		return true;
	}
	else {
		newVal = newVal + arr[i];
		count = count - 1;
		flag = getNum(arr, newVal, i-1);
	}
	return flag;
}
}
