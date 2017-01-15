package offer;

import java.util.Stack;

/**
 * 输入一个两个整数序列，第一个序列表示栈的压入顺序，判断第二个序列是否为该栈的弹出顺序，假设入栈的数字都不相等。
 * 结题思路：创建一个辅助栈，当栈顶元素和popA的指向的元素不等时入栈，当相等时弹出。注意合法和不合法的判断条件。
 * @author lh
 *
 */
public class PushAndLegalPop {
	  public boolean IsPopOrder(int [] pushA,int [] popA) {
	      Stack<Integer> stack = new Stack<>();
	      int i = 0;
	      int j = 0;
	      int len = pushA.length;
	      if(len == 0){
	    	  return true;
	      }
	      stack.push(pushA[i++]);
	      while(i < len || j < len){
	    	  while(stack.peek() != popA[j]){
		    	  if(i < len){
		    		  stack.push(pushA[i]);
		    	  }
		    	  else {
					return false;
				}
		    	  i++;
		      }
			  stack.pop();
			  j++;
	      }
	      
		  return true;
	    }
	  public static void main(String[] args){
		  int[] pushA = {1,2,3,4,5};
		  int[] popA = {4,3,5,1,2};
		  System.out.println(new PushAndLegalPop().IsPopOrder(pushA, popA));
	  }
}
