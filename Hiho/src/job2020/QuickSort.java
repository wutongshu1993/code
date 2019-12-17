package job2020;

public class QuickSort {
    public static int patition(int[] args, int low, int high){
        int pivokey = args[low];
        while(low < high){
            while(args[high] >= pivokey && low < high){
                high--;
            }
            args[low] = args[high];
            while (args[low] <= pivokey && low < high){
                low++;
            }
            args[high] = args[low];
        }
        args[low] = pivokey;
        return low;
    }

    public static void Qsort(int[] args, int low, int high){
        if(low < high){
            int mid = patition(args, low, high);
            Qsort(args, 0, mid-1);
            Qsort(args, mid+1, high);
        }

    }
    public static void main(String[] args){
        int[] a = {49,38,65,97,76,13,27,49};
        Qsort(a, 0, a.length-1);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

    }
}
