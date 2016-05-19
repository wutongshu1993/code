package leeCode;

/**
 * �ҳ��ַ��������е������ǰ׺������
 * ��abc��abcd,ab�򷵻�ab
 * �ҵ�˼���ǣ��Ƚ���һ��ѭ�����ҳ��������ַ�������̳���length��
 * Ȼ��ѭ��length�Σ�i����ÿ�ν���һ���ַ����ĵ�i���ַ�����ʣ���ַ����ĵ�i��λ�ý��бȽϣ����Ƚ�
 * ���ַ���������һ���ַ���������ͬ�Ļ����򽫵�i���ַ����뵽����ǰ׺�Ӽ��С�
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
