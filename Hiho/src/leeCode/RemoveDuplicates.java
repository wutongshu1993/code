package leeCode;

public class RemoveDuplicates {
	public int removeDuplicates(int[] nums) {
		if (nums.length == 0) return 0;
		int k = 1;
		int max = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if(nums[i] <= nums[i-1]){
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] > max) {
					k = j;
					max = nums[k];
					break;
				}

			}
			nums[i] = nums[k];
			}
			if (nums[i] > nums[i-1]) {
				k=i;
				max = nums[i];
			}
			
		}
		
		for(int i=1;i<nums.length;i++){
			if (nums[i] <= nums[i-1]) {
				return i;
			}
		}
		return nums.length;
	}
	public static void main(String[] args){
		int [] nums = {-1,0,0,0,0,3,3};
		System.out.println(new RemoveDuplicates().removeDuplicates(nums));
	}
}

/**
 * 		int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[index] != nums[i]) {
                nums[++index] = nums[i];
            }
        }
        return index+1;
*/