package util;

public class Stack {
private int[] st;
private int top;
private int count;
/**
 * 构造一个栈
 * @param size
 */
public Stack(int size){
	st = new int[size];
	top = -1;
	count = 0;
	
}
/**
 * 元素进栈
 * @param j
 */
public void push(int j){
	count ++;
	st[++top] = j;
	
}
/**
 * 元素出栈
 */
public int pop(){
	count--;
	return st[top--];
}
/**
 * 查询栈顶元素
 * @return
 */
public int peek(){
	return st[top];
}
/**
 * 查询栈是否为空
 * @return
 */
public boolean isEmpty(){
	//count --;
	return (top == -1);
}
/**
 * 查看栈里的所有元素
 */
public void list(){
	for(int i=0;i<st.length;i++)
		System.out.println(st[i]+"   ");
	System.out.println();
}
/**
 * 馋看栈里面包含了多少元素
 * @return
 */
public int getcount(){
	return count;
}
/**
 * 查看是否包含某个元素
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
 * 得到栈里的元素
 * @return
 */
public int[] getStr(){
	return st;
}
}
