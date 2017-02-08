package leeCode;

import java.util.ArrayList;
import java.util.List;

/**
 * ���ڻ��ݺ͵ݹ�ĵ���
 * ���Ĵ𰸣�����
 * ��һ���ַ�����������ַ����ָ�Ϊ������֣�ÿ�����ֶ��ǻ����ַ������������е����������Ľ��
 * For example, given s = "aab",
Return

[
  ["aa","b"],
  ["a","a","b"]
]
 * @author lh
 *
 */
public class PalindromePartitioning {
	List<List<String>> ret = new ArrayList<>();
	List<String> list = new ArrayList<>();
/**
 * ���Ǵ�ģ���Ϊÿ�ε����һ��Ԫ�ؾ��Ѿ��������һ��if�ˣ��������ֵ��û�м��뵽list��
 * @param s
 * @return
 */
	public List<List<String>> partition(String s) {
	
    if (isPalindrome(s)) {
    	ret.add(new ArrayList<>(list));
	}
	for(int i = 0; i < s.length(); i++){
    	if(isPalindrome(s.substring(0, i + 1))){
    		list.add(s.substring(0, i + 1));
    		partition(s.substring(i + 1));
    		list.remove(list.size() -1 );
    	}
    	
    }    
	return ret;
    }

public List<List<String>> partition3(String s) {
	List<List<String>> ret = new ArrayList<>();
	List<String> list = new ArrayList<>();
	backtracking(s, 0, ret, list);
	return ret;
}

public void backtracking(String s, int pos, List<List<String>> ret, List<String> list){
	if(pos == s.length()){
		ret.add(new ArrayList<>(list));
	}
	for(int i = pos; i < s.length(); i++ ){
		if(isPal(s, pos, i)){
			list.add(s.substring(pos, i + 1));
			backtracking(s, i + 1, ret, list);
			list.remove(list.size() - 1);
		}
	}
}
/**
 * �ж�һ���ַ����Ƿ��ǻ����ַ���
 * @param str
 * @return
 */
public boolean isPalindrome(String str){
	int i = 0;
	int j = str.length() - 1;
	while( i < j ){
		if(str.charAt(i++) != str.charAt(j--)){
			return false;
		}
	}
	return true;
}

public List<List<String>> partition2(String s) {
    List<List<String>> res = new ArrayList<List<String>>();
    List<String> list = new ArrayList<String>();
    dfs(s,0,list,res);
    return res;
 }
 
 public void dfs(String s, int pos, List<String> list, List<List<String>> res){
     if(pos==s.length()) res.add(new ArrayList<String>(list));//����ֻ����pos����ĩβ��ʱ��Ż����
     else{
         for(int i=pos;i<s.length();i++){
             if(isPal(s,pos,i)){
                 list.add(s.substring(pos,i+1));
                 dfs(s,i+1,list,res);
                 list.remove(list.size()-1);//���۳ɹ���񣬶�Ҫɾ��
             }
         }
     }
 }
 
 public boolean isPal(String s, int low, int high){
     while(low<high) if(s.charAt(low++)!=s.charAt(high--)) return false;
     return true;
 }
 

public static void main(String[] args){
	
	List<List<String>> list = new PalindromePartitioning().partition3("google");
}
}
