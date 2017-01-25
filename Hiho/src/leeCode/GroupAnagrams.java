package leeCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 将相同的字符串，归为一组
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
 * @author lh
 *
 */
public class GroupAnagrams {
	/**
	 * 最初的想法是，依次遍历字符数组，再依次和每个list比较，没有就新建。但是这样是n*n的复杂度 超时
	 * @param strs
	 * @return
	 */
public List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> ret = new ArrayList<>();
    int j;
    for(int i = 0; i < strs.length; i++){
    	for( j = 0; j < ret.size(); j++){
    		if(ret.get(j).size() > 0){
    			if (hasElem(ret.get(j).get(0), strs[i])) {
					ret.get(j).add(strs[i]);
					break;
				}
    		}
    	}
    	//遍历完了，也没有，就新加一个
    	if(j == ret.size()){
    		ArrayList<String> list = new ArrayList<>();
        	list.add(strs[i]);
        	ret.add(list);
    	}
    	
    }
	return  ret;
    }
/**
 * 判断两个字符串是否具有相同的字符
 * 我采用的是先把字符串转化为字符数组，然后对字符数组排序，排序后再比较
 * @param a
 * @param b
 * @return
 */
public boolean hasElem(String a, String b){
	if(a.length() != b.length()){
		return false;
	}
	char[] aArr = a.toCharArray();
	char[] bArr = b.toCharArray();
	Arrays.sort(aArr);
	Arrays.sort(bArr);
	for(int i = 0; i < a.length(); i++){
		if(aArr[i] != bArr[i]){
			return false;
		}
	}
	return true;
}

public List<List<String>> groupAnagrams2(String[] strs) {
	Map<Integer,Integer> map = new HashMap<>();//list中存ret中的序号
	List<List<String>> ret = new ArrayList<>();
	for(int i = 0; i < strs.length; i++){
		int code = getCode(strs[i]);
		if(map.get(code) == null){//没有对应的code
			ArrayList<String> list2 = new ArrayList<>();
        	list2.add(strs[i]);
        	ret.add(list2);
			map.put(code, ret.size() -1);
		}
		//对应的code已经有了
		else {
			ret.get(map.get(code)).add(strs[i]);
		}
	}
	return ret;
}



public int getCode(String str){
	//str.hashCode();
	if(str.length() == 0){
		return 0;
	}
	char[] arr = str.toCharArray();
	//arr.hashCode();
	Arrays.sort(arr);
	String res = String.valueOf(arr);
	int sum = 0;
	sum = res.hashCode();
	return sum;
}
public static void main(String[] args){
	int m = "abcd".hashCode();
	int n = "abcd".hashCode();
	String[] strs = {"c", "c"};
	new GroupAnagrams().groupAnagrams2(strs);
}
}
