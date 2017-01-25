package leeCode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import javax.lang.model.element.VariableElement;

public class DecodeString {
/**
 * s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 * @param s
 * @return ���
 */
	public String decodeString(String s) {
     String ret = "";
     String cur = "";
     int num = 1;
     Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == ']'){
				while( !stack.isEmpty() && stack.peek() != '['){
					cur += stack.pop();
				}
				if(stack.peek() == '['){
					stack.pop();
				}
				if(stack.peek() > '0' && stack.peek() <= '9'){
					num = stack.pop() - 48;
				}
				
				
				if(stack.isEmpty()){
					ret += cur;
					cur = "";
				}
				else {
					cur += nTimes(num, cur);
					ret = cur;
				}
				
				
			}
			else {
				stack.push(s.charAt(i));
				
			}
		
	} 
	return ret;  
    }
	/**
	 * ���Ĵ𰸣�
	 * ����ջ��һ�����ַ�����һ��������
	 * ���ַ��������������뷨��ÿ��������]�����ջ��Ԫ�ص����������㣬Ȼ�����ջ��Ԫ�ء�
	 * @param s
	 * @return
	 */
	public String decodeString2(String s) {
		Stack<String> result = new Stack<>();
		Stack<Integer> count = new Stack<>();
		int i = 0;
		result.push("");
		while (i < s.length()) {
			char ch = s.charAt(i);
			if(ch >= '0' && ch <='9'){
				int start = i;
//				i++;//����ͳһ����
				while (s.charAt(i + 1) >= '0' && s.charAt(i + 1) <='9') {
					i++;
				}
				count.push(Integer.parseInt(s.substring(start, i + 1)));
			}
			else if(ch == '['){
				result.push("");//����ܹؼ�����Ϊ��һ�ֵĿ�ʼ
			}
			else if( ch == ']') {
				String str = result.pop();
				StringBuilder sb = new StringBuilder();
				int times = count.pop();
				for(int j = 0; j < times; j++){
					sb.append(str);
				}
				result.push(result.pop() + sb.toString());
			}
			else {
				result.push(result.pop() + ch);
			}
			i++;
		}
		return result.pop();
	}
	public String dfs(String str){
		
		return null;
	}
	
	public String nTimes(int num, String str){
		String ret = "";
		while(num > 0){
			ret += str;
			num --;
		}
		return ret;
	}
	
	public static void main(String[] args){
		System.out.println(new DecodeString().decodeString2("3[ab2[ca]]"));
	}
}
