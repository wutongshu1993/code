package leeCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MajorityElementII {
	public List<Integer> majorityElement(int[] nums) {
		Arrays.sort(nums);
		int n = nums.length;
		int count = 1;
		List<Integer> list = new ArrayList<>();
		if (n == 0) {
			return list;
		}
		if (n == 1) {
			list.add(nums[0]);
			return list;
		}
		if (n == 2) {
			list.add(nums[0]);
			for (int i = 1; i < n; i++) {
				if (nums[i] != nums[i - 1]) {
					list.add(nums[i]);
				}
			}
			return list;
		}
//		int i = 1;
		for (int i = 1;i < n;i++) {
			while (i<n&&nums[i] == nums[i - 1]) {
				count++;
				i++;
			}
			
			if (count > n / 3) {
				count = 1;
				list.add(nums[i - 1]);
			}
			count=1;
		}
		return list;
	}

	public static void main(String[] args) {
		int[] nums = {88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,74,80,15,39,9,79,57,94,71,63,13,16,55,79,62,84,81,74,85,29,27,59,52,37,11,26,91,41,75,80,20,3,38,59,9,13,55,11,85,52,30,72,61,81,88,81,89,54,32,23,6,15,68,61,87,40,8,96,2,51,44,64,54,79,39,61,73,87,10,59,50,58,100,48,76,27,55,41,22,45,62,3,10,9,12,97,71,31,70,37,26,95,16,24,43,87,91,90,89,31,10,46,5,49,67,28,51,16,65,6,85,35,34,56,19,100,44,84,77,10,81,16,59,9,39,99,3,25,29,86,88,5,50,55,15,81,52,68,39,64,72,66,90,50,18,0,4,99,38,28,60,77,71,12,9,92,86,58,72,9,12,100,0,28,39,1,25,98,38,4,48,21,2,15,1,16,51,37,69,50,65,45,16,25,88,30,6,25,28,73,57,80,69,87,83,26,79,58,98,42,83,51,44,8,53,27,29,61,14,6,39,21,54,56,67,53,26,50,84,32,27,76,93,7,74,82,32,10,18,47,74,56,60,74,32,46,86,14,69,61,48,88,84,56,76,4,91,0,72,80,63,47,75,27,58,35,100,94,72,58,65,78,77,74,14,22,8,75,48,32,97,86,81,88,29,83,65,72,61,52,45,8,50,34,33,37,44,0,1,59,51,13,18,3,25,85,36,8,5,69,32,98,35,68,87,21,6,51,15,66,81,92,95,5,4,60,100,56,5,97,21,47,55,72,15,63,47,21,53,62,81,46,16,67,10,21,67,94,27,54,77,58,91,78,23,61,62,93,51,45,50,39,17,75,78,41,12,32,12,86,2,37,23,7,68,10,56,92,32,24,71,44,36,11,64,64,90,80,75,99,96,13,44,5,100,85,45,31,2,89,12,18,4,7,75,96,79,45,87,48,8,0,65,3,25,35,49,72,93,54,81,65,77,49,13,30,61,33,7,10,19,83,75,6,48,32,79,87,92,73,31,41,32,26,93,53,24,86,47,99,20,31,84,3,1,51,46,37,80,94,22,19,93,15,81,72,48,81,4,61,78,90,100,85,3,37,41,55,61,18,89,88,33,92,83,92,24,19,36,61,99,91,37,78,78,85,95,63,71,72,16,53,2,66,95,28,17,47,56 };
		new MajorityElementII().majorityElement(nums);
	}
}
