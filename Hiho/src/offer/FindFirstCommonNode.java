package offer;

import java.util.Stack;
/**
 * function ListNode(x){
    this.val = x;
    this.next = null;
}
 * @author lh
 *
 */
public class FindFirstCommonNode {
	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		Stack<ListNode> s1 = new Stack<>();
		Stack<ListNode> s2 = new Stack<>();
		ListNode p = pHead1;
		ListNode q = pHead2;
		ListNode result = null;
		while(p != null){
			s1.push(p);
			p = p.next;
		}
		while(q != null){
			s2.push(q);
			q = q.next;
		}
		while(!s1.empty() && !s2.empty()){
			if(s1.peek() != s2.peek()){
			
				return result;
			}
			else {
				result = s1.pop();
				
				s2.pop();
			}
		}
		return result;
    }
	public static void main(){
		
	}
}
