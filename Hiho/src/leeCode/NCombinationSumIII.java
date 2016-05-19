package leeCode;

import java.util.ArrayList;
import java.util.List;

/**
 * ���Ĵ�
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Ensure that numbers within the set are sorted in ascending order.
 * @author lh
 *
 */
public class NCombinationSumIII {
public List<List<Integer>> combinationSum3(int k, int n) {
    if (k<1 || n<1) {
		return null;
	}
	//��Ž��
	List<List<Integer>> res = new ArrayList<>();
    //�����������������
	List<Integer> cur = new ArrayList<>();
	helper(res, cur, 0, k, n, 1);
	return res;  
    }
/**
 * 
 * @param res
 * @param cur
 * @param sum ��ǰ��
 * @param k ��ʣ������
 * @param n Ŀ���
 * @param level 
 */
public void helper(List<List<Integer>> res, List<Integer> cur, int sum, int k, int n, int level){
	if (sum == n && k==0) {
		res.add(new ArrayList<>(cur));
		return;
	}
	else if (sum > n || k<=0) {
		return;
	}
	for (int i = level; i < 10; i++) {
		cur.add(i);
		helper(res, cur, sum+i, k-1, n, i+1);
		cur.remove(cur.size()-1);
	}
}
public static void main(String[] args){
	List<List<Integer>> res = new NCombinationSumIII().combinationSum3(3, 7);
}
}
