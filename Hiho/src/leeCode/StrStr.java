package leeCode;
/**
 * Ѱ����С�ַ��Ӵ���λ��KMP
 * @author lh
 *
 */
public class StrStr {
	/**
	 * �������İ취������
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
 * ���ܴ��ĵ�i��λ�ÿ�ʼ���κ��ִ����бȽ�needle.charAt(j) != haystack.charAt(i + j)�������ڵĻ���i++������j++
 * ��j == neddle.length()�ҵ�������û�ҵ�
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
    		break;//������һ��ѭ��
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
	//int
	return null;
}
public static void main(String[] args){
	System.out.println(new StrStr().strStr3("abcabd", "abd"));
}
}
