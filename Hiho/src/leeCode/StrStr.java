package leeCode;
/**
 * Ѱ����С�ַ��Ӵ���λ��KMP
 * @author lh
 *
 */
public class StrStr {
public int strStr(String haystack, String needle) {
    char[] stack = haystack.toCharArray();
    char[] ned = needle.toCharArray();
    int len1 = stack.length;
    int len2 = ned.length;
    boolean flag = false;
    int i = 0;
    int j = 0;
	while(i < len1 && !flag){
    	if(stack[i] == ned[j]){
    		i ++;
    		j ++;
    	} 
     }  
	return 0; 
    }
}
