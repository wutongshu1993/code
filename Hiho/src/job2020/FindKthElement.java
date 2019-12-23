package job2020;

/**
 * 寻找无序数组中第k大的元素
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * 两种思路：1，利用快排的思想，和快排不同的是，可以判断k属于哪一部分，因此递归的时候只递归需要的那一半数据
 * 2，将数据放入一个排序的容器里面，再取出来就好了
 */
public class FindKthElement {
    public static int findKthSort(int[] args, int low, int high, int k){
        if(low < high){
            int mid = QuickSort.patition(args, low, high);
            if(args.length - mid == k){
                return args[mid];
            }else if(args.length - mid > k){
                return findKthSort(args, mid+1, high, k);
            }else if (args.length - mid < k){
                return findKthSort(args, low, mid-1, k);
            }
        }
        return args[low];
    }

    public static void main(String[] args){
        //int[] arr = {3,2,1,5,6,4};
//        int k = 2;
        int[] arr = {7,6,5,4,3,2,1};
        int k = 2;
        int kele = findKthSort(arr, 0, arr.length-1, k);
        System.out.println(kele);
    }
}
