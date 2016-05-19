package leeCode;

import java.util.ArrayList;

import javax.xml.namespace.QName;

public class PalindromeNumber {
	/*public boolean isPalindrome(int x) {
		if (x < 0)
			return false;
		if (x == 0)
			return true;
		int len = 0;
		int base = x;
		while (base > 0) {
			base = base / 10;
			len++;
		}
		int a = 0;
		int b = 0;
		for (int i = 1; i < len / 2 + 1; i++) {
			
			a =(int) ((int) (x % (Math.pow(10, i))) / (Math.pow(10, i-1))) ;
//				b = x % (10 ^ (len - i + 1));
			b = (int) ((int) (x % (Math.pow(10, (len - i + 1)))) / (Math.pow(10, (len - i )))) ;
			if (a != b) {
				return false;
			}
		}
		return true;
	}*/
	//���нϺõķ���
	public boolean isPalindrome2(int x) {
	    if(x<0 || (x!=0 && x%10==0))
	    return false;
	    int res = 0;
	       while(x>res){
	        res = res*10 + x%10;
	        x = x/10;
	       }
	    return (x==res || x==res/10);
	}
	/**
	 * �ж�һ��listnode�ǲ��ǻ��ĵģ��ҵ��뷨�ǽ�listnodeת��Ϊ
	 * arraylist�����ж�
	 * @param head
	 * @return
	 */
	/*public boolean isPalindrome(ListNode head){
		if (head==null) return true;
		if (head.next == null) return true;
		ArrayList<Integer> s = new ArrayList<>();
		while(head!=null){
			s.add(head.val);
			head = head.next;
		}
		return isMatch(s);
	}
	public boolean isMatch(ArrayList<Integer> a){
		int c=0;
		int b=0;
		int len = a.size();
		for(int i=0;i<len;i++){
			c = a.get(i);
			b = a.get(len-1-i);
			if (c!=b) return false;
		}
		return true;
	}*/
	//���нϺõķ���,ͨ�������η�ת
	public boolean isPalindrome(ListNode head){
		if(head==null) return true;
		if(head.next == null) return true;
		int length = 0;
		ListNode p = head;
		//ȷ����������
		while(p!=null){
			length++;
			p = p.next;
		}
		p = head;
		//����벿�ַ�ת
		int half = (length+1)/2;
		ListNode q = head;
		for(int i=0;i<half;i++){
			q = q.next;
		}
		//��ʼ��ת,qָ����ε�ͷ
		ListNode r = q.next;
		q.next = null;
		ListNode m;
		while(r != null){
			m = r.next;
			r.next = q;
			q = r;
			r = m;
		}
		
		//���αȽ�
		while(q!=null && p!=null){
			if (p.val==q.val) {
				p = p.next;
				q = q.next;
			}
			else {
				return false;
			}
		}
		
		return true;
	}
	public static void main(String[] args){
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(-2);
		ListNode n3 = new ListNode(-2);
		ListNode n4 = new ListNode(1);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		System.out.println(new PalindromeNumber().isPalindrome(n1));
	}
}
