package leeCode;
/**
 * 题目的意思是输入一个数组nums（数组里面有n个数），输出一个数组output，output[i]的值是nums中的所有值的累积（除了nums[i]）.
[1,2,3,4], return [24,12,8,6]
要求：不用除法，o(n)复杂度
 * @author lh
 *
 */
public class ProductExceptSelf {
public int[] productExceptSelf(int[] nums) {
    int sum=1;
    int count =0;
    int[] output=new int[nums.length];
	for(int i=0;i<nums.length;i++){
    	if (nums[i]==0) {//用考虑有0的情况
			count++;
		}
    	else {
    		sum *= nums[i];
		}
    	if (count>1) {
			break;
		}
		
    }  
	if (count==2) {
		for(int i=0;i<nums.length;i++){
			output[i] = 0;
		}
	}
	else if(count==0) {
		for(int i=0;i<nums.length;i++){
			output[i] = sum/nums[i];
		}
	}
	else {//0的个数是1个
		for(int i=0;i<nums.length;i++){
			if (nums[i]==0) {
				output[i]=sum;
			}
			else output[i] = 0;
		}
	}
	
	return output; 
    }
/**
 * 符合答案的答案
 * @param nums
 * @return
 */
public int[] productExceptSelf2(int[] nums) {
	int[] output = new int[nums.length];
	output[0] = 1;
	for(int i=1;i<nums.length;i++){
		output[i] = output[i-1]*nums[i-1];
	}
	for(int i=nums.length-1;i>=0;i--){
		output[i] *= output[0];
		output[0] *= nums[i];
	}
	return output;
}
public static void main(String[] args){
	int[] nums ={1,0};
	new ProductExceptSelf().productExceptSelf(nums);
}
}
