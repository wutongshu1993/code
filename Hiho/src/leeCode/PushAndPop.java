package leeCode;

import java.util.Stack;

/**
 * 用两个栈实现一个队列，完成队列的push和pop操作
 * 2016.12.31
 * @author lh
 *
 */
public class PushAndPop {
	Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.push(node);
    }
    
    public int pop() {
    	while(!stack1.isEmpty()){
    		stack2.push(stack1.pop());
    	}
    	int res = stack2.pop();
    	while(!stack2.isEmpty()){
    		stack1.push(stack2.pop());
    	}
    	return res;
    }
}
