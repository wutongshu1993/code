package offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 有n个数，两两组成二元组，差最小的有多少对呢？差最大呢？
 *  输入包含多组测试数据。
 对于每组测试数据：
 N - 本组测试数据有n个数
 a1,a2...an - 需要计算的数据
 保证:1<=N<=100000,0<=ai<=INT_MAX.
 对于每组数据，输出两个数，第一个数表示差最小的对数，第二个数表示差最大的对数。
 输入：6
45 12 45 32 5 6
输出：1 2
 * @author Administrator
 *
 */
public class Main3 {
public static void main(String[] args){
	Scanner scanner = new Scanner(System.in);
	while(scanner.hasNext()){
		int n = scanner.nextInt();
		int[] nums = new int[n];
		for(int i = 0; i < n; i++){
			nums[i] = scanner.nextInt();
		}
		getResult(nums);
	}
	scanner.close();
}
public static void getResult(int[] nums){
	Arrays.sort(nums);
	int len = nums.length;
	//如果数字全部相同
	if(nums[0] == nums[len-1]){
		int temp = len * (len-1) / 2;
		System.out.println(temp +" "+temp);
		return;
	}
	Map<Integer, Integer> map = new TreeMap();//用于存储数组中的数字
	for(int i= 0; i <len; i++){
		if(map.containsKey(nums[i])){
			map.put(nums[i], map.get(nums[i])+1);
		}
		else {
			map.put(nums[i], 1);
		}
	}
	int count1 = 0;//差最小的对数，出现在相邻两个数的做差中。
	int count2 = 0;//差最大的对数,只能出现在最大数-最小数中
	
	if(map.size() == nums.length){//数组中没有重复的数字
		int min = nums[1]-nums[0];
		for(int i = 1; i < len; i++){
			if(nums[i] - nums[i-1] < min){
				min = nums[i] - nums[i-1];
				count1 = 1;
			}
			else if(nums[i] - nums[i-1] == min){
				count1++;
			}
		}
	}
	else {//数组中有重复的数字
		
		for(int key : map.keySet()){
			int val = map.get(key); 
			if( val > 1 ){
				count1 += val * (val-1) / 2;
			}
		}
	}
	
	//计算差最大对数
	List<Integer> keys = new ArrayList<>(map.keySet());
	int val1 = map.get(keys.get(0));
	int val2 = map.get(keys.get(keys.size() - 1));
	count2 = val1 * val2;
	System.out.println(count1 + " "+ count2);
}
}
