package leeCode;

/**
 * 找出字符串数组中的最长公共前缀子序列
 * 如abc，abcd,ab则返回ab
 * 我的思想是，先进行一次循环，找出，所以字符串的最短长度length，
 * 然后循环length次（i），每次将第一个字符串的第i个字符串和剩余字符串的第i个位置进行比较，当比较
 * 到字符数组的最后一个字符串还是相同的话，则将第i个字符加入到公共前缀子集中。
 * @author lh
 *
 */
public class LongestCommonPrefix {
public String longestCommonPrifix(String[] strs){
	StringBuilder common = new StringBuilder();
	if (strs==null||strs.length==0) {
		return common.toString();
	}
	if (strs.length == 1) {
		return strs[0];
	}
	String s1 = strs[0];
	int length = strs[0].length();
	for(int i=0;i<strs.length;i++){
		length = Math.min(length, strs[i].length());
	}
	for(int i=0;i<length;i++){
		for (int j = 1; j < strs.length; j++) {
			String s2 = strs[j];
			if (!(s1.substring(i, i+1).equals(s2.substring(i, i+1)))) {
				return common.toString();
			}
			if (j==strs.length-1) {
				common.append(s1.substring(i, i+1));
			}
		}
		
	}
	return common.toString();
}

public static void main(String[] args){
	String[] strs = {
			/*"abca","abc"*/"a","abc","ab"
	};
	System.out.println(new LongestCommonPrefix().longestCommonPrifix(strs));
}
}
