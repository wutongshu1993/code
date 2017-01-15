package offer;
/**
 * һ�����������������������֮�⣬���������ֶ����������Ρ���д�����ҳ�������ֻ����һ�ε����֡�Ҫ��ʱ�临�Ӷ�Ϊo(n)
 * ˼·�����ֻ��һ�����ֳ�����һ�Σ�������򣬽����Ϊ��������ˣ��������Ϊ���飬ÿ�����һ��ֻ����һ�ε����֡�
 * ������򣬻�ȡ�������ֵ���������ǽ���е�һλΪ1�������ڵ�kλ������ÿ������k�Ƿ�Ϊ1�������Ϊ���顣
 * �ռ�Ϊo(1)
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
//�ж�num�ĵ�kλ�Ƿ�Ϊ1
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
