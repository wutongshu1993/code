package leeCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import util.ArrayUtils;

public class Subsets {
	/**
	 * 数组中的元素不可以重复
	 * 给出数组的子集，子集中的元素以非递减的顺序返回；没有重复的子集
	 * 看的答案，采用位运算；而如何根据该位是1，就加入到子集中呢？采用的是左移的想法
	 * 还有一个就是判断子集中的元素一共有多少个，2^n个，采用的是1>>num.lenth()的做法
	 * @param nums
	 * @return
	 */
public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
	Arrays.sort(nums);
	int len = nums.length;
	int max = 1<<len;//这个表示2^n
    for(int i=0;i<max;i++){
    	List<Integer> list = new ArrayList<>();
    	int index = 0;
    	int j = i;
    	while(j>0){
    		//判断最后一位是否为1，若为1，则加入到集合中
    		if ((j&1)==1) {
				list.add(nums[index]);
			}
			index++;
    		j=j>>1;
    	}
    	result.add(list);
    }   
	return result; 
    }
/**
 * 和上题的差别是，这里允许参数数组中的元素可以有重复的
 * 想法
 * @param nums
 * @return
 */
public List<List<Integer>> subsetsWithDup(int[] nums) {
//    List<List<Integer>> result = new ArrayList<>();
//	Arrays.sort(nums);
//	int len = nums.length;
//	int max = 1<<len;
//    for(int i=0;i<max;i++){
//    	List<Integer> list = new ArrayList<>();
//    	int index = 0;
//    	int j = i;
//    	while(j>0){
//    		//判断最后一位是否为1，若为1，则加入到集合中
//    		if ((j&1)==1) {
//				list.add(nums[index]);
//			}
//			index++;
//    		j=j>>1;
//    	}
//    	if (!result.contains(list)) {
//    		result.add(list);
//		}
//    	
//    }   
//	return result; 
	 Arrays.sort(nums);
	    List<List<Integer>> result = new ArrayList<List<Integer>>();
	    result.add(new ArrayList<Integer>());
	    int begin = 0;
	    for(int i = 0; i < nums.length; i++){
	        if(i == 0 || nums[i] != nums[i - 1]) begin = 0;
	        int size = result.size();
	        for(int j = begin; j < size; j++){
	            List<Integer> cur = new ArrayList<Integer>(result.get(j));
	            cur.add(nums[i]);
	            result.add(cur);
	        }
	        begin = size;
	    }
	    return result;
    }
public boolean hasList(List<List<Integer>> result, List<Integer> list){
	int len = result.size();
	if (result.contains(list)) {
		return true;
	};
	return false;
}





















public List<List<Integer>> subset2(int[] nums){
	int len = nums.length;
	int n = (int)Math.pow(2, len) - 1;//子集中一共有多少个元素
	int i = n-1;
	List<List<Integer>> ret = new ArrayList<>();
	Arrays.sort(nums);//先排序
	while(n >= 0){
		int temp = n;//第n个子集
		int index = len - 1;//子集中的序号
		List<Integer> list = new ArrayList<>();
		while(temp != 0){
			int cur = temp & 1;//当前指向的元素是否加入到集合中
			if(cur == 1){
				list.add(0, nums[index]);
			}
			index --;
			temp = temp >> 1;
		}
		ret.add(list);
		n--;
	}
	return ret;
}

public static void main(String[] args){
//	int[] nums = {1,2,2};
//	int max = -5<<2;//第一个操作数乘以2的幂，指数的值是由第二个数给出的
//	new Subsets().subsetsWithDup(nums);
//	
//	System.out.println(max);
	
	int[] nums = {1,2,3};
	System.out.println(new Subsets().subset2(nums));
}
}
