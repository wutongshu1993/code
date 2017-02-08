package offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * ��n������������ɶ�Ԫ�飬����С���ж��ٶ��أ�������أ�
 *  �����������������ݡ�
 ����ÿ��������ݣ�
 N - �������������n����
 a1,a2...an - ��Ҫ���������
 ��֤:1<=N<=100000,0<=ai<=INT_MAX.
 ����ÿ�����ݣ��������������һ������ʾ����С�Ķ������ڶ�������ʾ�����Ķ�����
 ���룺6
45 12 45 32 5 6
�����1 2
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
	//�������ȫ����ͬ
	if(nums[0] == nums[len-1]){
		int temp = len * (len-1) / 2;
		System.out.println(temp +" "+temp);
		return;
	}
	Map<Integer, Integer> map = new TreeMap();//���ڴ洢�����е�����
	for(int i= 0; i <len; i++){
		if(map.containsKey(nums[i])){
			map.put(nums[i], map.get(nums[i])+1);
		}
		else {
			map.put(nums[i], 1);
		}
	}
	int count1 = 0;//����С�Ķ����������������������������С�
	int count2 = 0;//�����Ķ���,ֻ�ܳ����������-��С����
	
	if(map.size() == nums.length){//������û���ظ�������
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
	else {//���������ظ�������
		
		for(int key : map.keySet()){
			int val = map.get(key); 
			if( val > 1 ){
				count1 += val * (val-1) / 2;
			}
		}
	}
	
	//�����������
	List<Integer> keys = new ArrayList<>(map.keySet());
	int val1 = map.get(keys.get(0));
	int val2 = map.get(keys.get(keys.size() - 1));
	count2 = val1 * val2;
	System.out.println(count1 + " "+ count2);
}
}
