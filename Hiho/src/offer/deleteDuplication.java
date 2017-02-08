package offer;

import java.util.HashMap;
import java.util.Map;

/**
 * ɾ�������������ظ��Ľڵ㣬�ظ��Ľڵ㲻�豣��
 * @author Administrator
 *
 */
public class deleteDuplication {
	public ListNode deleteDuplication(ListNode pHead) {
		ListNode pre = null;
		ListNode pNode = pHead;
		while(pNode != null){
			ListNode pNext = pNode.next;
			boolean needDelete = false;
			if(pNext != null && pNext.val == pNode.val){
				needDelete = true;
			}
			//����Ҫɾ��
			if(!needDelete){
				pre = pNode;
				pNode = pNext;
			}
			else {
				int val = pNode.val;
				ListNode del = pNode;
				while(del != null && del.val == val){
					pNext = del.next;
					del = null;
					del = pNext;
				}
				if(pre == null){
					pHead = pNext;
				}
				else {
					pre.next = pNext;
				}
				pNode = pNext;
			}
		}
		return pHead;
	}
	public static void main(String[] args){
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(2);
		ListNode n4 = new ListNode(4);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		new deleteDuplication().deleteDuplication(n1);

	}
}
