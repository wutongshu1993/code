package util;

import java.security.PublicKey;

public class Queue {
private int[] values;
private int begin=-1;
private int end = -1;
public Queue(int size) {
	values = new int[size];
	// TODO Auto-generated constructor stub
}
/**
 * �����
 * @param value
 */
public void push(int value){
	values[++begin] = value;
}
/**
 * ������
 * @return
 */
public int pop(){
	return values[++end];
}
public boolean isEmpty(){
	return end==begin;
}
}
