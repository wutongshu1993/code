package leeCode;

public class HouseRobber {
public int rob(int[] nums){
	int rob = 0;
	int noRob = 0;
	int max = 0;
	for(int i=0;i<nums.length;i++){
		rob = noRob + nums[i];
		noRob = max;
		max = Math.max(rob, noRob);
	}
	
	return max;
}
public static void main(String[] args){
	int[] nums = {4,2,3,9};
	int a = new HouseRobber().rob(nums);
}
}
