package offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * 想法：数组的最后一个元素是根元素，然后小于根元素的为左孩子，大于根元素的为右孩子。然后就可以递归判断了，如果在大于根元素的序列
 * 中出现一个小于根元素的值，则结束为false，
 * @author lh
 *
 */
public class VerifySquenceOfBST {
public boolean VerifySquenceOfBST(int [] sequence) {
    int len = sequence.length;
    if(sequence == null || len == 0){
    	return false;
    }
    if(len == 1){
    	return true;
    }
    int root = sequence[len-1];
    ArrayList<Integer> left = new ArrayList<>();
    ArrayList<Integer> right = new ArrayList<>();
    int i, j;
    for(i = 0; i < len - 1; i++){
    	if(sequence[i] < root){
    		left.add(sequence[i]);
    		
    	}
    	else {
			break;
		}
    }
    j = i;
    for(j = i; j < len - 1; j++){
    	if(sequence[j] < root){
    		return false;
    	}
    	right.add(sequence[j]);
    }
    int[] left_arr = listToArray(left);
    int[] right_arr = listToArray(right);
    if(left_arr.length == 0){
    	return VerifySquenceOfBST(right_arr);
    }
    if(right_arr.length == 0){
    	return VerifySquenceOfBST(left_arr);
    }
    return VerifySquenceOfBST(left_arr) && VerifySquenceOfBST(right_arr);
    }
/*class ListToArray<T>{
	public T[] listToArray(List<T> list){
		int len = list.size();
		T[] array = new T[len];
		for(int i = 0; i < len; i++){
			array[i] = list.get(i);
		}
		return array;
	}
}*/
public int[] listToArray(List<Integer> list){
	int len = list.size();
	int[] array = new int[len];
	for(int i = 0; i < len; i++){
		array[i] = list.get(i);
	}
	return array;
}
public static void main(String[] args){
	int[] array = {7,4,6,5};
	System.out.println(new VerifySquenceOfBST().VerifySquenceOfBST(array));
}
}
