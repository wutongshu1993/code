package leeCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给一个数组，返回它的全排列
 * 精神不好，看的答案
 * @author lh
 *
 */
public class Permutations {
public List<List<Integer>> permute(int[] nums) {
      List<List<Integer>> ret = new ArrayList<>();
      //List<Integer> list = new ArrayList<>();
      dfs(ret,  nums, 0);
      return ret;
    }

public void dfs(List<List<Integer>> ret, int[] nums, int i){
	int len = nums.length;
	if(len == i){
		List<Integer> list = new ArrayList<>();
		arrayTolist(list, nums);
		ret.add(new ArrayList<>(list));
		return;
	}
	
	for(int j = i; j < len; j++){
		swap(nums, i, j);
		dfs(ret,  nums, i+1);
		swap(nums, i, j);
		
	}
	
}

public void swap(int[] nums, int i, int j){
	int temp = nums[i];
	nums[i] = nums[j];
	nums[j] = temp;
}

public void arrayTolist(List<Integer> list, int[] nums){
	int len = nums.length;
	for(int i = 0; i < len; i++){
		list.add(nums[i]);
	}
}

public static void main(String[] args){
	int[] nums = {1,2,3};
	new Permutations().permute(nums);
}
}
