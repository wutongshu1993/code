package offer;

import java.util.Arrays;
/**
 * ��������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬���ҳ�������֡���������һ������Ϊ9������{1,2,3,2,2,2,5,4,2}��
 * ��������2�������г�����5�Σ��������鳤�ȵ�һ�룬������2����������������0��
 * @author lh
 *
 */
public class MoreThanHalfNum {
public int MoreThanHalfNum_Solution(int [] array) {
    int len = array.length;
    Arrays.sort(array);
    int count = 0;
    int mid = array[len / 2];
    for(int i = 0; i < len; i++){
    	if(array[i] == mid){
    		count ++;
    	}
    	if(count > len/2){
    		return mid;
    	}
    }
	return 0;
    }
public static void main(String[] args){
	int[] array = {1,2,3,2,2,2,5,2,3};
	System.out.println(new MoreThanHalfNum().MoreThanHalfNum_Solution(array));
}
}
