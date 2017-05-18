package bop;
class ListNode{
	public ListNode(int val) {
		// TODO Auto-generated constructor stub
		this.val = val;
	}
	int val;
	ListNode next;
}
public class ReversePartList {
		public static ListNode reverse_part(ListNode head, int len){
			if (head == null)
				return null;
			ListNode pre = null, next = null, newhead = head;
//			��ת����
			int i = 0;
//			��ת
			while ((i < len) && (head != null)){
				next = head.next;
				head.next = pre;
				pre = head;
				head = next;
				i ++;
			}
//			�������ת�ĸ��������������len�������Ѿ���ת�����һ���ڵ�
			if (head == null)
				return pre;
//			�ݹ�����ÿһ���Ѿ���ת������
			newhead.next = reverse_part(head, len);
//			�����ѷ�ת��ͷ���
			return pre;
		}
		public static void main(String[] args){
			ListNode p1 = new ListNode(1);
			ListNode p2 = new ListNode(2);
			ListNode p3 = new ListNode(3);
			ListNode p4 = new ListNode(4);
			ListNode p5 = new ListNode(5);
			ListNode p6 = new ListNode(6);
			p1.next = p2;
			p2.next = p3;
			p3.next = p4;
			p4.next = p5;
			p5.next = p6;
			ListNode h = reverseNode(p1);
			System.out.println(2);
		}
		public static ListNode reverseNode(ListNode head){
			if(head == null || head.next == null){
				return head;
			}
			ListNode next = head.next;
			head.next = null;
			ListNode newHead = reverseNode(next);
			next.next = head;
			return newHead;
			
		}
	}

