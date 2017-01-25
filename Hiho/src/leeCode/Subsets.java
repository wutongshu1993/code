package leeCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import util.ArrayUtils;

public class Subsets {
	/**
	 * �����е�Ԫ�ز������ظ�
	 * ����������Ӽ����Ӽ��е�Ԫ���Էǵݼ���˳�򷵻أ�û���ظ����Ӽ�
	 * ���Ĵ𰸣�����λ���㣻����θ��ݸ�λ��1���ͼ��뵽�Ӽ����أ����õ������Ƶ��뷨
	 * ����һ�������ж��Ӽ��е�Ԫ��һ���ж��ٸ���2^n�������õ���1>>num.lenth()������
	 * @param nums
	 * @return
	 */
public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
	Arrays.sort(nums);
	int len = nums.length;
	int max = 1<<len;//�����ʾ2^n
    for(int i=0;i<max;i++){
    	List<Integer> list = new ArrayList<>();
    	int index = 0;
    	int j = i;
    	while(j>0){
    		//�ж����һλ�Ƿ�Ϊ1����Ϊ1������뵽������
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
 * ������Ĳ���ǣ�����������������е�Ԫ�ؿ������ظ���
 * �뷨
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
//    		//�ж����һλ�Ƿ�Ϊ1����Ϊ1������뵽������
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
	int n = (int)Math.pow(2, len) - 1;//�Ӽ���һ���ж��ٸ�Ԫ��
	int i = n-1;
	List<List<Integer>> ret = new ArrayList<>();
	Arrays.sort(nums);//������
	while(n >= 0){
		int temp = n;//��n���Ӽ�
		int index = len - 1;//�Ӽ��е����
		List<Integer> list = new ArrayList<>();
		while(temp != 0){
			int cur = temp & 1;//��ǰָ���Ԫ���Ƿ���뵽������
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
//	int max = -5<<2;//��һ������������2���ݣ�ָ����ֵ���ɵڶ�����������
//	new Subsets().subsetsWithDup(nums);
//	
//	System.out.println(max);
	
	int[] nums = {1,2,3};
	System.out.println(new Subsets().subset2(nums));
}
}
