package leeCode;

import java.util.List;

import leeCode.DeleteNode.ListNode;

/**
 * Given linked list: 1->2->3->4->5, and n = 2.
 * 
 * After removing the second node from the end, the linked list becomes
 * 1->2->3->5.
 * 
 * //�ҵ�˼·���ȼ����listnode�ĳ���len��������n������������len-n��
 * //����һ��˼·������ָ�룬һ����ģ�һ�����ģ����������ƶ�n�ĵ�λ��Ȼ���ĺ�����һ���ƶ���
 * ����ĵ���ĩβ��ʱ��������ָ����Ǹ�node����Ҫɾ����node��ǰ��
 * 
 * @author lh
 *
 */
public class RemoveNthFromEnd {
	// �ҵ�˼·���ȼ����listnode�ĳ���len��������n������������len-n��
	// ����һ��˼·������ָ�룬һ����ģ�һ�����ģ����������ƶ�n�ĵ�λ��Ȼ���ĺ�����һ���ƶ�������ĵ���ĩβ��ʱ��������ָ����Ǹ�node����Ҫɾ����node��ǰ��
	public ListNode removeNthFromEnd(ListNode head, int n) {
		int i = 0, j = 0, m = 0;
		ListNode p = head;
		ListNode next = head;
		if (p.next == null) {
			return null;
		}
		while (p.next != null) {
			p = p.next;
			i++;// ����
		}
		j = i - n + 1;
		p = head;
		if (j == 0) {
			head = head.next;
		} else {

			while (m < j) {
				next = p;
				p = p.next;
				m++;
			}
			if (next.next != null) {
				next.next = p.next;
			}
		}
		return head;

	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		// ListNode n4 = new ListNode(3);
		// ListNode n5 = new ListNode(3);
		n1.next = n2;
		n2.next = n3;
		n3.next = null;
		new RemoveNthFromEnd().removeNthFromEnd(n1, 3);
	}
}
/**
 * if(head == null){ return null; }
 * 
 * ListNode fast = head; ListNode slow = head; for(int i = 0; i < n; i++){ fast
 * = fast.next; } if(fast == null){ head = head.next; return head; }
 * while(fast.next != null){ fast = fast.next; slow = slow.next; } ListNode curr
 * = slow.next; slow.next = curr.next;
 * 
 * return head;
 **/