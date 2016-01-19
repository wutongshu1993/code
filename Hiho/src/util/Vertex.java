package util;

import java.util.ArrayList;

/**
 * 
 * @author lh
 *
 */
public class Vertex {
public char label;
public int index;//�±�
public boolean isVisited;
private ArrayList<Vertex> next = null;
public Vertex(char lab){
	this.label = lab;
	isVisited = false;
}
//Ϊ�ڵ�����ٽӵ�
public void addAdj(Vertex ver){
	if (next == null) {
		next = new ArrayList<>();
	}
	next.add(ver);
}
/*
 * �õ��ڽӵ�����
 */
public ArrayList<Vertex> getAdj(){
	return next;
}
public void setIndex(int index){
	this.index = index;
}
public String toString(){
	return "����"+label+",�±�"+index+".";
}
}
