package offer;
/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度为o(n)
 * 思路：如果只有一个数字出现了一次，依次异或，结果就为该数。因此，将数组分为两组，每组仅有一个只出现一次的数字。
 * 分组规则，获取所有数字的异或结果，记结果中第一位为1的数字在第k位，根据每个数字k是否为1将数组分为两组。
 * 空间为o(1)
 * @author lh
 *
 */
public class FindNumsAppearOnce {
public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
    int result = 0;    
	for(int i = 0; i < array.length; i++){
        	result = result ^ array[i];
        }
	int k = 0;
	while((result & 0x01) != 1){
		result = result >> 1;
		k++;
	}
	for(int i = 0; i < array.length; i++){
		if(isBit1(array[i], k)){
			num1[0] = num1[0] ^ array[i];
		}
		else {
			num2[0] = num2[0] ^ array[i];
		}
	}
    }
//判断num的第k位是否为1
public boolean isBit1(int num, int k){
	num = num >> k;
	if((num & 0x01) == 1){
		return true;
	}
	return false;
}
public static void main(String[] args){
	int[] array = {2,4,3,6,3,2,5,5};
	int[] nums1 = new int[1];
	int[] nums2 = new int[1];
	new FindNumsAppearOnce().FindNumsAppearOnce(array,nums1, nums2);
	System.out.println(nums1[0] +" "+ nums2[0]);
}
}
