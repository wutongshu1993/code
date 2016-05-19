package leeCode;

import java.util.LinkedList;
/**
 * �ж������Ƿ�ƥ��
 * 
 * @author lh
 *
 */
public class IsValid {
//��һ���Ϻõİ취�ǣ�������������������ţ���ֱ����ջ��������������������жϵ�ǰ�������Ƿ��ջ��ƥ�䣬�����ƥ����ֱ�ӷ���false
public boolean isValid(String s) {
    char[] arr = s.toCharArray();
    LinkedList<Character> stack = new LinkedList<>();
    Character peak,curr;
    for(int i=0;i<arr.length;i++){
    	curr = arr[i];
    	if (stack.isEmpty()) {
    		stack.addLast(curr);
		}
    	else {
    		peak = stack.getLast();
        	if (isMatch(peak, curr)) {
    			stack.removeLast();
    		}
        	else {
    			stack.addLast(curr);
    		}
		}
    	
    }
    if (stack.size()==0) {
		return true;
	}
	return false;
    }
public boolean isMatch(Character s, Character t){
	if ((s=='(' && t==')') || (s=='{' && t=='}') || (s=='[' && t==']')) {
		return true;
	}
	return false;
}

public static void main(String[] args){
	System.out.println(new IsValid().isValid("([)]"));
}
}
