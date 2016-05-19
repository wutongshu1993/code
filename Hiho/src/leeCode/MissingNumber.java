package leeCode;

import java.util.Arrays;

public class MissingNumber {
	//普通法
public int missingNumber(int[] num){
	Arrays.sort(num);
	for(int i=0;i<num.length;i++){
		if (num[i]!=i) {
			return i;
		}
	}
	return num.length;
}
//二分法
public int missingNumber2(int[] num){
	Arrays.sort(num);
	int n = num.length;
	int low=0;
	int high=num.length;
	while(low<high){
		int mid = (high+low)/2;
		if (num[mid]==mid) {
			low=mid+1;
		}
		else if (num[mid]>mid) {
			high=mid;
		}
	}
	
	return low;
}
//异或法 异或自己是0，异或0是自己
//所以我们把0-n都异或一遍，再对着给定数组异或一遍，结果就是缺失的数。
public int missingNumber3(int[] nums){
	int res = 0;
    for(int i = 0; i <= nums.length; i++){
        res ^= i == nums.length ? i : i ^ nums[i];
    }
    return res;
}
//另一个非常简单的答案
/**
 *  int sum = 0, i = 0;

    for (; i < nums.length; i++)
        sum = sum + i - nums[i];

    return (sum + i);
 * @param args
 */
public static void main(String[] args){
	int[] num = {0,5,2,3,1,6};
	System.out.println(new MissingNumber().missingNumber3(num));
}
}
