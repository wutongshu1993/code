package job2020;

/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai)
 * 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 */
class ContainerWithMostWater{
    public static int getMostWater(int[] arr){
        int max = 0;
        int low = 0;
        int high = arr.length -1;
        while(low < high){
            max = Math.max(max, Math.min(arr[low], arr[high]) * (high -low));
            if(arr[high] > arr[low]){
                low++;
            }else {
                high--;
            }
        }
        return max;
    }

    public static void main(String[] args){
        int arr[] = {1,8,6,2,5,4,8,3,7};
        int max = getMostWater(arr);
        System.out.println(max);
    }
}