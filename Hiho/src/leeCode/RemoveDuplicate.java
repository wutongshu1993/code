package leeCode;

import leeCode.DeleteNode.ListNode;

/**
 * Given a sorted linked list, delete all duplicates such that
 *  each element appear only once.
For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
 * 
 * @author lh
 *
 */
public class RemoveDuplicate {
	public ListNode deleteDupicates(ListNode head) {
/*		if (head == null || head.next == null) {
			return head;
		} else {//����2���ڵ�
			ListNode p = head;
			if( p!= null){
					if (p.val == p.next.val) {// ɾ��next�������
						p.next = p.next.next;
					}
					else {
						p = p.next;
					}
					deleteDupicates(p);
			}
			return head;
		}*/
/*		//����һ�ֲ��õݹ�ķ���
		ListNode cur = head;
		ListNode pre = new ListNode(0);
		pre.next = cur;
		while(cur != null){
			if (pre.val == cur.val) {
				pre.next = cur.next;
			}
			else {
				pre = pre.next;
			}
			cur = cur.next;
		}
		return head;*/
		//���бȽ�����ķ���
		if(head == null || head.next == null)return head;
        head.next = deleteDupicates(head.next);
        return head.val == head.next.val ? head.next : head;
		
	}
public static void main(String[] args){
	ListNode n1 = new ListNode(1);
	ListNode n2 = new ListNode(2);
	ListNode n3 = new ListNode(2);
//	ListNode n4 = new ListNode(3);
//	ListNode n5 = new ListNode(3);
	n1.next = n2;
	n2.next = n3;
	n3.next = null;
//	n4.next = null;
	ListNode head = new RemoveDuplicate().deleteDupicates(n1);
	
}
}
