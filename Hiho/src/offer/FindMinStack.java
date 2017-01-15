package offer;

import java.util.Stack;

/**
 * ����ջ�����ݽṹ�����ڸ�������ʵ��һ���ܹ��õ�ջ��СԪ�ص�min������
 * ˼·����һ������վ������ÿ��ջ״̬����Сֵ
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
