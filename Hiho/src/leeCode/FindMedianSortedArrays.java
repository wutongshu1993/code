package leeCode;
/**
 * 输入两个有序的数组，找到他们的中位数（个数为基数，中间的数；个数为偶数，中间的两个数的平均值）
 * @author lh
 *
 */
public class FindMedianSortedArrays {
	/**
	 * 解法一：将所有的元素合并到一个数组里面
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public double findMedianSortedArrays(int[] nums1, int[] nums2){
		int m = nums1.length;
		int n = nums2.length;
		int[] num = new int[m+n];
		int i=0;int j =0;int pos=0;
		while(i<m && j<n){
			if (nums1[i]<=nums2[j]) {
				num[pos++] = nums1[i++];
			}
			if (nums1[i]>nums2[j]) {
				num[pos++] = nums2[j++];
			}
		}
		while(i<m){
			num[pos++] = nums1[i++];
		}
		while(j<n){
			num[pos++] = nums2[j++];
		}
		if (num.length % 2 ==1) {
		return num[pos/2];
		}
		else {
			return (num[pos/2]+num[pos/2-1])/2.0;
		}
		
	}
	/**
	 * 解法二，找第k小的元素，首先在nums1中找到k/2的元素（如果k/2>m,则找最后一个元素）k1
	 * 找nums中第k-k1个元素，k2
	 * 如果k1<k2,则k1及比k1小的数都不可能是第k小的元素
	 * k1=k2 则k1即为中间元
	 * k1>k2，k2及比k2小的数都不是第k小元素
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public double findKth(int[] nums1,int startA,int m,int[] nums2,int startB,int n,int k){
		//假设m总是小于等于n
		if (m>n) {
			return findKth(nums2,startB, n, nums1,startA, m, k);
		}
		if (m==0) {
			return nums2[startB+k-1];
		}
		if (k==1) {
			return Math.min(nums1[startA], nums2[startB]);
		}
		int pa = Math.min(k/2, m);
		int pb = k-pa;
		int k1 = nums1[startA + pa-1];
		int k2 = nums2[startB+pb-1];
		if (k1 < k2) {
			return findKth(nums1, startA+pa, m-pa, nums2, startB, n, k-pa);
		}
		if (k1 == k2) {
			return nums1[k/2-1];
		}
		else {
			  return findKth(nums1, startA, m, nums2, startB+pb, n-pb, k-pb);
		}
//		return 0;
	}
	
	public double findMedianSortedArrays2(int[] nums1, int[] nums2){
		int m = nums1.length;
		int n = nums2.length;
		int total = m+n;
		if ((total & 1)==1) {
			return findKth(nums1, 0, m, nums2, 0, n, total/2+1);
		}
		else {
			return (findKth(nums1, 0, m, nums2, 0, n, total/2)
					+ findKth(nums1, 0, m, nums2, 0,n, total/2+1))/2.0;
		}
	}
	public static void main(String[] args){
		int[] nums1={2};
		int[] nums2 = {};
		System.out.println(new FindMedianSortedArrays().findMedianSortedArrays2(nums1, nums2));
	}
}
