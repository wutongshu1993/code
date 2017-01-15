package offer;

import java.util.Stack;

/**
 * ����һ�������������У���һ�����б�ʾջ��ѹ��˳���жϵڶ��������Ƿ�Ϊ��ջ�ĵ���˳�򣬼�����ջ�����ֶ�����ȡ�
 * ����˼·������һ������ջ����ջ��Ԫ�غ�popA��ָ���Ԫ�ز���ʱ��ջ�������ʱ������ע��Ϸ��Ͳ��Ϸ����ж�������
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
