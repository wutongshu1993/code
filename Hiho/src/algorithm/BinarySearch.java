package algorithm;

/**
 * 前提：有序列表
 * 平均时间复杂度：log(n)
 * @author huiminlu
 *
 */
public class BinarySearch {
int search(int[] arr, int item) {
	int low = 0;
	int high = arr.length - 1;	
	while(low <= high && low >= 0 && high < arr.length) {
		int mid = (low + high + 1) / 2;
		if(arr[mid] > item) {
			high = mid - 1;
		}else if(arr[mid] < item) {
			low = mid +1;
		}else {
			return mid;
		}
	}
	return -1;
}
public static void main(String[] args) {
	int[] arr = {1,3,5,7,9};
	int ret = new BinarySearch().search(arr, 2);
	System.out.println(ret);
}
}
