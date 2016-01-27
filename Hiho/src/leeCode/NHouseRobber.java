package leeCode;

/**
 *  it will automatically contact the police if two adjacent houses were
 *   broken into on the same night.
 * @author lh
 *
 */
public class NHouseRobber {
public int rob(int[] nums) {
	int nontake = 0;
	int max = 0;
	int take = 0;
	for(int i=0;i<nums.length;i++){
		take = nontake + nums[i];
		nontake = max;
		max = Math.max(nontake, take);
	}
	return max;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//     int[][] money = new int[size][size];
//     List<Integer>[][]  loc = new List[size][size];
//     for(int i=0;i<size;i++){
//    	 money[i][i] = nums[i];
//    	 List<Integer> list = new ArrayList<>();
//    	 list.add(i);
//    	 loc[i][i] = list;
//     }
//     for(int l=2;l<=size;l++)
//     for(int low=0;low<=size-l+1;low++)
//     {
//    	 int high = low+l-1;
//    	 int best = money[low][high-1];
//    	 List<Integer> tempList = new ArrayList<>();
//    	 tempList = loc[low][high-1];
//    	 int 
//    	 for(int r=low+1;r<=high;r++){
//    		 int temp = money[][]
//    	 }
//    	 
//     }
	
    }
}
