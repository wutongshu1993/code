package leeCode;

import java.util.LinkedList;
/**
 * 判断括号是否匹配
 * 
 * @author lh
 *
 */
public class IsValid {
//另一个较好的办法是，如果括号是属于左括号，则直接入栈，如果是属于右括号则判断当前的括号是否和栈顶匹配，如果不匹配则直接返回false
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
