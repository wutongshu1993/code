package offer;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 * 思路：用一个辅助站来保存每个栈状态的最小值
 * @author lh
 *
 */
public class FindMinStack {
	Stack<Integer> stack = new Stack<>(); 
	Stack<Integer> helper = new Stack<>();
	public void push(int node) {
	    stack.push(node);
	    if(helper.isEmpty()){
	    	helper.push(node);
	    }
	    else {
			if(helper.peek() > node){
				helper.push(node);
			}
			else {
				helper.push(helper.peek());
			}
		}
	    }
	    
	    public void pop() {
	        stack.pop();
	        helper.pop();
	    }
	    
	    public int top() {
	    	return stack.peek();
	    }
	    
	    public int min() {
	        return helper.peek();
	    }
}
