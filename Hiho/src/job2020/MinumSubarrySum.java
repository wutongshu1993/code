package job2020;

/**
 * 给定一个整形数组和一个数字s，
 * 找到数组中最短的一个连续子数组，使得连续子数组的数字和sum>=s，返回这个最短的连续子数组的长度值.
 * 解法：两个指针（i，j分别指向子序列的开始和结尾），指针包含的范围内的和如果大于sum，
 * 则将i指针向后移动，否则将j指针，移动后如果满足大于s，则和minlen比较。
 */
public class MinumSubarrySum {
    public static int find(int s, int[] nums){
        int i = 0;
        int j = -1;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        while(i < nums.length){
            if(sum < s && j+1 < nums.length){
                sum += nums[++j];
            }else{
                sum -= nums[i++];
            }
            if(sum >= s){
                minLen = Math.min(minLen, j-i+1);
            }
        }
        if(minLen == Integer.MAX_VALUE){
            return 0;
        }
        return minLen;
    }
    public static void main(String[] args){
        int[] nums = {2,3,1,2,4,3};
        int res = find(7, nums);
        System.out.println(res);
    }
}
