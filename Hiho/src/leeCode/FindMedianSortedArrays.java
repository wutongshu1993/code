package leeCode;
/**
 * ����������������飬�ҵ����ǵ���λ��������Ϊ�������м����������Ϊż�����м����������ƽ��ֵ��
 * @author lh
 *
 */
public class FindMedianSortedArrays {
	/**
	 * �ⷨһ�������е�Ԫ�غϲ���һ����������
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
	 * �ⷨ�����ҵ�kС��Ԫ�أ�������nums1���ҵ�k/2��Ԫ�أ����k/2>m,�������һ��Ԫ�أ�k1
	 * ��nums�е�k-k1��Ԫ�أ�k2
	 * ���k1<k2,��k1����k1С�������������ǵ�kС��Ԫ��
	 * k1=k2 ��k1��Ϊ�м�Ԫ
	 * k1>k2��k2����k2С���������ǵ�kСԪ��
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public double findKth(int[] nums1,int startA,int m,int[] nums2,int startB,int n,int k){
		//����m����С�ڵ���n
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
