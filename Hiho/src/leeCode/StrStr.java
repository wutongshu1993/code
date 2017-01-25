package leeCode;
/**
 * 寻找最小字符子串的位置KMP
 * @author lh
 *
 */
public class StrStr {
	/**
	 * 这种最笨最笨的办法，很慢
	 * 
	 * @param haystack
	 * @param needle
	 * @return
	 */
public int strStr(String haystack, String needle) {
    char[] stack = haystack.toCharArray();
    char[] ned = needle.toCharArray();
    int len1 = stack.length;
    int len2 = ned.length;
    int i = 0;
    int p = 0;
    int q = 0;
    if(len1 == 0 && len2 == 0){
    	return 0;
    }
    if(len1 < len2){
    	return -1;
    }
	while(i < len1){
    	p = i;
    	q = 0;
		while(q < len2 && p < len1 && stack[p] == ned[q] ){
    		p ++;
    		q ++;
    	} 
    	if( q == len2){
    		return i;
    	}
    	else {
			i ++;
		}
     }  
	return -1; 
    }
/**
 * 从总串的第i个位置开始依次和字串进行比较needle.charAt(j) != haystack.charAt(i + j)，不等于的话就i++，否则j++
 * 当j == neddle.length()找到，否则没找到
 * @param haystack
 * @param needle
 * @return
 */
public int strStr3(String haystack, String needle) {
    for(int i = 0; ; i++)
    for(int j = 0; ;j++)
    {
    	if(j == needle.length()){
    		return i;
    	}
    	if(i + j == haystack.length()){
    		return -1;
    	}
    	if(needle.charAt(j) != haystack.charAt(i + j)){
    		break;//跳出这一层循环
    	}
    }
    }

public int strStr2(String haystack, String needle) {
    return haystack.indexOf(needle);
}
public int strStrKMP(String haystack, String needle){
	int i = 0;
	int len1 = haystack.length();
	int len2 = haystack.length();
	
	return 0;
}

public int[] getNext(char[] c){
	int
	return null;
}
public static void main(String[] args){
	System.out.println(new StrStr().strStr3("abcabd", "abd"));
}
}
