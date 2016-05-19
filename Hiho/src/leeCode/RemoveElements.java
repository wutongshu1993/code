package leeCode;
import leeCode.DeleteNode.ListNode;
public class RemoveElements {
public ListNode removeElements(ListNode head, int val){
//	ListNode next=head.next;
	if (head==null) {
		return null;
	}
//	if (head.next==null && head.val == val) {
//		return null;
//	}
	else {
	ListNode dumy = new ListNode(0);
	dumy.next = head;
	ListNode p = dumy;
	ListNode q = head;
	while(q!=null){
		if (q.val==val) {
			p.next = q.next;
//			deleteNode(p);
		}
		else {
			p = p.next;
		}
		q= q.next;
	}
	
	return dumy.next;
	}
}
public void deleteNode(ListNode node){
	ListNode next = node.next;
	if (next!=null) {
		node.val = next.val;
		node.next = next.next;
	}
	
}
public static void main(String[] args){
//	ListNode node1 = new ListNode(1);
//	ListNode node2 = new ListNode(2);
//	ListNode node3 = new ListNode(3);
	ListNode node4 = new ListNode(2);
//	node1.next = node2;
//	node2.next = node4;
//	node3.next = node4;
	node4.next = null;
	new RemoveElements().removeElements(node4, 2);
}
/*指向同一个引用，值事实上是一样的
 * public static void main(String[] args){
int[] a1 = {1,2,3,4,5};
int[] a2;
a2 = a1;
for(int i=0;i<a2.length;i++){
	a1[i]++;
}
for(int i=0;i<a2.length;i++){
	System.out.println(a1[i]);
	System.out.println(a2[i]);
}
}*/
}
