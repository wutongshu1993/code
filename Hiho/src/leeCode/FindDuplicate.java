package leeCode;

import java.util.Arrays;

/**
 * һ����СΪ����������n+1��������С��1~n����֤��������һ�������ظ��ġ�
 * �����ظ�������
 * Ҫ�󣬲��ܸı������ֵ�������һ������ռ䣬���Ӷ�С��o��n*n��
 * �����ظ�����ֻ��һ���ײ��Ҹ������Ա��ظ����
 * ��򵥵İ취�������Ժ��ٱȽϣ������ﲻ�ܽ�������
 * �ڶ��ַ����Ǳ���
 * @author lh
 *
 */
public class FindDuplicate {
	/**
	 * n*n
	 * @param nums
	 * @return
	 */
public int findDuplicate(int[] nums) {
    int n = nums.length;
    int pos=0;
    for(int i=0;i<n;i++)
    	for(int j=i+1;j<n;j++){
    		if (nums[i]==nums[j]) {
				pos++;
			}
    		if (pos>0) {
				return nums[i];
			}
    	}
	return 0;
    }
public int findDuplicate2(int[] nums){
	Arrays.sort(nums);
	for(int i=1;i<nums.length;i++){
		if (nums[i] == nums[i-1]) {
			return nums[i];
		}
	}
	return 0;
}
/**
 * 2�ֲ��ң������з�ΧΪ1~10��С�ڵ���5�����������5����ǰ�벿����
 * @param nums
 * @return325
 * 
 */
public int findDuplicate3(int[] nums){
	int len = nums.length;
	int low = 1;
	int high = len-1;
	int media = 0;
	while(low<high ){
		media = (high+low)/2;
		int num = 0;
		for(int i=0;i<len;i++){
			if (nums[i]<=media ) {
				num++;
			}
			//С�ڵ����м����ĸ�������
			if (num>media) {
				high = media;
				break;
			}
		}
		
		if (num<=media){
			low = media+1;//+1!!!!!
		}
	}
	if (low== high) {
		return low;
	}
	return 0;
}
public static void main(String[] args){
	int[] nums = {1,3,2,3,4,5};//
	System.out.println(new FindDuplicate().findDuplicate3(nums));
}
}
