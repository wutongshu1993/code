package offer;
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * @author lh
 *
 */
public class Clone {
	public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead == null){
        	return null;
        }
		RandomListNode head = new RandomListNode(pHead.label);
        RandomListNode q = head;
        RandomListNode p = pHead;
        while(p.next != null){
        	RandomListNode next = new RandomListNode(p.next.label);
        	if(p.random != null){
        		RandomListNode random = new RandomListNode(p.random.label);
        		q.random = random;
        	}
        	
        	q.next = next;
        	q = q.next;
        	p = p.next;
        }
		return head;
    }
	public static void main(String[] args){
		RandomListNode n1 = new RandomListNode(1);
		RandomListNode n2 = new RandomListNode(2);
		RandomListNode n3 = new RandomListNode(3);
		RandomListNode n4 = new RandomListNode(4);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n1.random = n3;
		n2.random = n4;
		RandomListNode r = new Clone().Clone(n1);
		System.out.println(1);
	}
}
