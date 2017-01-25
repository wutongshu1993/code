package offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;


/**
 * �������ų���С����
 * ����һ�����������飬����������������ƴ�������ų�һ��������ӡ��ƴ�ӳ���������������С��һ����
 * ������������{3��32��321}�����ӡ���������������ųɵ���С����Ϊ321323��
 * ����ȫ���У��ٴ�ȫ�������ҳ���С����,����treeset
 * @author lh
 *
 */
public class PrintMinNumber {
	 public String PrintMinNumber(int [] numbers) {
		 if(numbers == null || numbers.length == 0){
			 return null;
		 }
		 TreeSet<String> set = new TreeSet<>();
		 recur(numbers, 0, set);	
		 return set.first()+"";
	    }
	 public void recur(int[] numbers, int begin, TreeSet<String> set){
		int len = numbers.length;
		if(len == 0){
			return;
		} 
		if(begin == len - 1){
			 String num = getNum(numbers);
			 set.add(num);
		 }
		 for(int i = begin; i < numbers.length; i++){
			 swap(numbers, begin, i);
			 recur(numbers, begin + 1, set);
			 swap(numbers, begin, i);
		 }
	 }
	 public String getNum(int[] nums){
		 String str= "" ;
		 for(int i = 0; i < nums.length; i++){
			 str += nums[i];
		 }
		 return str;
	 }
	 public void swap(int[] nums, int a, int b){
		 int temp = nums[a];
		 nums[a] = nums[b];
		 nums[b] = temp;
	 }
	 
	 
	 
	 
	 
	 //����һ�ַ������Զ���һ���Ƚϵķ���
	 public String solve(int[] numbers){
		 int len = numbers.length;
		 ArrayList<Integer> list = new ArrayList<>();
		 String res = "";
		 for(int i = 0; i < len; i++){
			 list.add(numbers[i]);
		 }
		 Collections.sort(list, new Comparator<Integer>() {
			 @Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				String s1 = o1+""+o2;
				String s2 = o2 +""+o1;
				 return s1.compareTo(s2);
			}
		});
		 for(int j : list){
			 res += j;
		 }
		 return res;
	 }
	 public static void main(String[] args){
		int[] arr = {3334,3,3333332};
		String str = new PrintMinNumber().PrintMinNumber(arr);
		System.out.println(str);
	 }
}
