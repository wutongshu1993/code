package offer;
/**
 * 统计一个数字在排序数组中出现的次数。
 * @author lh
 *
 */
public class GetNumberOfK {
	 public int GetNumberOfK(int [] array , int k) {
	     int i = 0;
	     int count = 0;
		 while(i < array.length){
	    	 if(array[i] < k){
	    		 i++;
	    	 }
	    	 else if(array[i] == k){
	    		 count++;
	    		 i++;
	    	 }
	    	 else {
				return count;
			}
	    	 
	     }  
		 return count;
	    }
	 public static void main(String[] args){
		 int[] arr = {1,2,3,3,3,3,4,5};
		 System.out.println(new GetNumberOfK().GetNumberOfK(arr, 3));
	 }
}
