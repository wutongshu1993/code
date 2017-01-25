package leeCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main2 {
public int find(int[] nums){
	Arrays.sort(nums);
	for(int i = 0; i < nums.length; ){
		if(nums[i] == nums[i + 2]){
			i = i + 3;
		}
		else {
			return nums[i];
		}
	}
	return 0;
}
public static void main(String[] args){
	Scanner scanner = new Scanner(System.in);
	List<Integer> list = new ArrayList<>();
	if(scanner.hasNext()){
		list.add(scanner.nextInt());
	}
	int[] nums = new int[list.size()];
	list.toArray(nums);
	System.out.println(new Main2().find(nums));
}
}
