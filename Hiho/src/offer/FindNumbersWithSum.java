package offer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，
 * 是的他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 
 * @author Administrator
 *
 */
public class FindNumbersWithSum {
	//这个复杂度为n*logn
public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
    int num1, num2, min,index;
    boolean flag = false;
    min = Integer.MAX_VALUE;
    ArrayList<Integer> res = new ArrayList<>();
    res.add(null);
    res.add(null);
	for(int i= 0; i < array.length; i++){
    	num1 = array[i];
    	index = Arrays.binarySearch(array, sum - num1);
    	if(index >= 0){
    		flag = true;
    		num2 = array[index];
    		if (num1 * num2 < min) {
				min = num1 * num2;
				res.set(0, num1);
				res.set(1, num2);
			}
    	}
    } 
	if(flag){
		return res;
	}
	else {
		return new ArrayList<>();
	}
    }

public static void main(String[] args){
	int[] array = {1,2,4,7,11,15};
	ArrayList<Integer> res = new FindNumbersWithSum().FindNumbersWithSum(array, 15);
	System.out.println(res);
}
}
