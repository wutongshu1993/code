package offer;

import java.util.ArrayList;
import java.util.Arrays;

import javax.naming.spi.DirStateFactory.Result;

/**
 * 最小k个数
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * @author lh
 *
 */
public class GetLeastNumbers {
public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
    int len = input.length;
    ArrayList<Integer> result = new ArrayList<>();
    if(k > len){
    	return result;
    }
    
    Arrays.sort(input);
    for(int i = 0; i < k; i++){
    	result.add(input[i]);
    }
	return result;
    }

public static void main(String[] args){
	int[] input = {2,5,1,6,2,7,3,8};
	System.out.println(new GetLeastNumbers().GetLeastNumbers_Solution(input, 10));
}
}
