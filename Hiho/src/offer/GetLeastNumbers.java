package offer;

import java.util.ArrayList;
import java.util.Arrays;

import javax.naming.spi.DirStateFactory.Result;

/**
 * ��Сk����
 * ����n���������ҳ�������С��K��������������4,5,1,6,2,7,3,8��8�����֣�����С��4��������1,2,3,4,��
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
