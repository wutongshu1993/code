package util;

public class Stack {
private int[] st;
private int top;
private int count;
/**
 * ����һ��ջ
 * @param size
 */
public Stack(int size){
	st = new int[size];
	top = -1;
	count = 0;
	
}
/**
 * Ԫ�ؽ�ջ
 * @param j
 */
public void push(int j){
	count ++;
	st[++top] = j;
	
}
/**
 * Ԫ�س�ջ
 */
public int pop(){
	count--;
	return st[top--];
}
/**
 * ��ѯջ��Ԫ��
 * @return
 */
public int peek(){
	return st[top];
}
/**
 * ��ѯջ�Ƿ�Ϊ��
 * @return
 */
public boolean isEmpty(){
	//count --;
	return (top == -1);
}
/**
 * �鿴ջ�������Ԫ��
 */
public void list(){
	for(int i=0;i<st.length;i++)
		System.out.println(st[i]+"   ");
	System.out.println();
}
/**
 * ����ջ��������˶���Ԫ��
 * @return
 */
public int getcount(){
	return count;
}
/**
 * �鿴�Ƿ����ĳ��Ԫ��
 * @param s
 * @return
 */
public boolean isContains(int i){
	for(int k=0;k<st.length;k++){
		if (st[k]==i) {
			return true;
		}
	}
	return false;
}
/**
 * �õ�ջ���Ԫ��
 * @return
 */
public int[] getStr(){
	return st;
}
}
