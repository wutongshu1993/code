package leeCode;//δ���,���Ĵ�
import leeCode.DeleteNode.ListNode;
public class NReverseLinkedList {
public static ListNode reverseList(ListNode head){/*tail �� head��Ȼ��ָ���ͬһ����ַ����tail���޸Ļ�Ӱ�쵽head��ֵ
	
	if (head==null || head.next==null) {
		return head;
	}
	else {
		ListNode front = head;
		ListNode half = head;
		ListNode tail = head;
//		tail.next = null;
		half.next = null;
		while(head.next != null){
			head = head.next;
			front = head;
			front.next = half;
			half = front;
		}//����ѭ��ʱ
		return half; 
	}	
*/  ListNode next = head.next;
	head.next = null;
	if (next != null) {
		ListNode root = reverseList(next);
		next.next = head;
		return root;
		
	}
	return head;

	}
public static void main(String[] args){
	ListNode a = new ListNode(1);
	ListNode b = new ListNode(2);
	ListNode c = new ListNode(3);
	a.next = b;
	b.next = c;
	c.next = null;
	reverseList(a);
	while(a.next != null)
		System.out.println(a.val);
}
}
