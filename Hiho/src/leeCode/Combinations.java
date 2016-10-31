package leeCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
 * @author lh
 *
 */
public class Combinations {
	/**
	 * n个元素中选出k个子集,不区分顺序,
	 * 看了一点答案
	 * @param n
	 * @param k
	 * @return
	 */
public List<List<Integer>> combine(int n, int k) {
   if(n == 0 || k == 0){
	   return ret;
   }
	dfs(new ArrayList<Integer>(), n, k, 1);
    return ret;
    }
List<List<Integer>> ret = new ArrayList<>();
public void dfs(List<Integer> list, int n, int k, int s ){
	if(list.size() == k){
		ret.add(new ArrayList<>(list));
		return ;
	}
	int leftLen = k - list.size();
	for(int i = s; i <= n - leftLen + 1 ; i++){//s是添加的第一个元素, leftLen是还可以添加几个元素，故为了保证最后一共有k个元素，i应该小于
		list.add(i);
		dfs(list, n, k, i + 1);
		list.remove(list.size() - 1);
	}
}
public static void main(String[] args){
	System.out.println(new Combinations().combine(4, 2));;
}
}
