package offer;

import java.util.ArrayList;
import java.util.List;

/**
 * ����һ���������飬�жϸ������ǲ���ĳ�����������ĺ�������Ľ����
 * ����������Yes,�������No���������������������������ֶ�������ͬ��
 * �뷨����������һ��Ԫ���Ǹ�Ԫ�أ�Ȼ��С�ڸ�Ԫ�ص�Ϊ���ӣ����ڸ�Ԫ�ص�Ϊ�Һ��ӡ�Ȼ��Ϳ��Եݹ��ж��ˣ�����ڴ��ڸ�Ԫ�ص�����
 * �г���һ��С�ڸ�Ԫ�ص�ֵ�������Ϊfalse��
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
