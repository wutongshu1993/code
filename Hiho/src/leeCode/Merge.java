package leeCode;

import java.util.Arrays;

/**
 * ���ź������������nums1[]��nums2[]�ϲ���nums1�У�nums1�Ĵ�С���ڵ���m+n��
 * ��һ���ط���Ҫע�⣬nums1������Ϊ�գ���������Ԫ�ض����г�ʼֵ0�ġ�
 * @author lh
 *
 */
public class Merge {
	
public void merge(int[] nums1, int m, int[] nums2, int n) {
	if (m==0) {
		nums1 = nums2;
		return;
	}
	if (n==0) {
		return;
	}   
	int[] c = new int[m+n];
       int i=0;
       int j=0;
       int pos =0;
       while(i<m&& j<n){
    	   if (nums2[j]<=nums1[i]) {
			c[pos++] = nums2[j++];
		}
    	   else {
			c[pos++] = nums1[i++];
		}
       }
       while(i<m){
    	   c[pos++] = nums1[i++];
       }
       while(j<n){
    	   c[pos++] = nums2[j++];
       }
       nums1 = c;
    }
public void merge2(int[] nums1, int m, int[] nums2, int n){
	/*if (m==0) {
	 * nums1 = nums2;//������ֵΪɶ����
		nums1 = Arrays.copyOf(nums2, n);
		return;
	}
	if (n==0) {
		return;
	}*/
	int pos = m+n-1;
	int i=m-1;
	int j= n-1;
	while(i>=0 && j>=0){
		if (nums1[i] >= nums2[j]) {
			nums1[pos--] = nums1[i--];
		}
		else {
			nums1[pos--] = nums2[j--];
		}
	}
	while(i>=0){
		nums1[pos--] = nums1[i--];
	}
	while(j>=0){
		nums1[pos--] = nums2[j--];
	}
}
public static void main(String[] args){
	int[] nums1 = {0};
	int[] nums2 = {1};
	new Merge().merge2(nums1, 0, nums2, 1);
}
}
