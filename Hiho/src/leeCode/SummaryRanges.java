package leeCode;


import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
public List<String> summaryRanges(int[] nums) {
    List<String> list = new ArrayList<>();
    if (nums.length == 0) {
		return list;
	}
    if (nums.length==1) {
		list.add(nums[0]+"");
		return list;
	}
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(nums[0]);
    int count =1;
    int j=1;
    while(j<nums.length){
    while(j<nums.length && nums[j]==nums[j-1]+1){
    	count++;
    	j++;
    }
    if (count==1) {
		list.add(stringBuilder.toString());
		stringBuilder.setLength(0);
		stringBuilder.append(nums[j]);
		j++;
		if (j==nums.length) {
			list.add(stringBuilder.toString());
		}
		count =1;
	}
    
    if (count > 1 && j<nums.length) {
		stringBuilder.append("->"+nums[j-1]);
		list.add(stringBuilder.toString());
		stringBuilder.setLength(0);
		stringBuilder.append(nums[j]);
		count=1;
		j++;
		if (j==nums.length) {
			list.add(stringBuilder.toString());
			stringBuilder.setLength(0);
		}
	
    }
    
    if (count>1 && j==nums.length) {
    	stringBuilder.append("->"+nums[j-1]);
		list.add(stringBuilder.toString());
		stringBuilder.setLength(0);
	}
    }
    
//    for(int i=1;i<nums.length;i++){
////    		if(nums[i]!=nums[i-1]+1){
////    			stringBuilder.append("->"+nums[i-1]);
////    			list.add(stringBuilder.toString());
////    			stringBuilder.setLength(0);
////    			stringBuilder.append(nums[i]);
////    		}
////    		if (i==nums.length-1) {
////				list.add(stringBuilder.toString());
////			}
//    	if (nums[i]==nums[i-1]+1) {
//			count++;
//		}
//    	else {
//			if (count>0) {
//				stringBuilder.append("->"+nums[i-1]);
//				list.add(stringBuilder.toString());
//				stringBuilder.setLength(0);
//				stringBuilder.append(nums[i]);
//				count=0;
//			}else {
//				stringBuilder.setLength(0);
//				stringBuilder.append(nums[i]);
//				list.add(stringBuilder.toString());
//			}
//			
//		}
//    }
	return list;
    }
public static void main(String[] args){
	int[] nums = {0,1,2,4,5,7};
	new SummaryRanges().summaryRanges(nums);
}
}
