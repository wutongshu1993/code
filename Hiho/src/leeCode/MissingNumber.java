package leeCode;

import java.util.Arrays;

public class MissingNumber {
	//��ͨ��
public int missingNumber(int[] num){
	Arrays.sort(num);
	for(int i=0;i<num.length;i++){
		if (num[i]!=i) {
			return i;
		}
	}
	return num.length;
}
//���ַ�
public int missingNumber2(int[] num){
	Arrays.sort(num);
	int n = num.length;
	int low=0;
	int high=num.length;
	while(low<high){
		int mid = (high+low)/2;
		if (num[mid]==mid) {
			low=mid+1;
		}
		else if (num[mid]>mid) {
			high=mid;
		}
	}
	
	return low;
}
//��� ����Լ���0�����0���Լ�
//�������ǰ�0-n�����һ�飬�ٶ��Ÿ����������һ�飬�������ȱʧ������
public int missingNumber3(int[] nums){
	int res = 0;
    for(int i = 0; i <= nums.length; i++){
        res ^= i == nums.length ? i : i ^ nums[i];
    }
    return res;
}
//��һ���ǳ��򵥵Ĵ�
/**
 *  int sum = 0, i = 0;

    for (; i < nums.length; i++)
        sum = sum + i - nums[i];

    return (sum + i);
 * @param args
 */
public static void main(String[] args){
	int[] num = {0,5,2,3,1,6};
	System.out.println(new MissingNumber().missingNumber3(num));
}
}
