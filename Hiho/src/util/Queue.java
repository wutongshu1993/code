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
 * 入队列
 * @param value
 */
public void push(int value){
	values[++begin] = value;
}
/**
 * 出队列
 * @return
 */
public int pop(){
	return values[++end];
}
public boolean isEmpty(){
	return end==begin;
}
}
