package util;

import java.util.ArrayList;

/**
 * 
 * @author lh
 *
 */
public class Vertex {
public char label;
public int index;//下标
public boolean isVisited;
private ArrayList<Vertex> next = null;
public Vertex(char lab){
	this.label = lab;
	isVisited = false;
}
//为节点添加临接点
public void addAdj(Vertex ver){
	if (next == null) {
		next = new ArrayList<>();
	}
	next.add(ver);
}
/*
 * 得到邻接点数组
 */
public ArrayList<Vertex> getAdj(){
	return next;
}
public void setIndex(int index){
	this.index = index;
}
public String toString(){
	return "顶点"+label+",下标"+index+".";
}
}
