package homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import util.Edge;

public class MinTreeKruskal {
//存储顶点的数组
//存储边
public static void getMin(int[] v,Edge[] E){
	Arrays.sort(E);//E实现了comparable接口，故可调用该方法
	ArrayList<HashSet> sets = new ArrayList<>();
	for (int i = 0; i < v.length; i++) {
		HashSet<Integer> set = new HashSet<>();
		set.add(v[i]);
		sets.add(set);
	}
	System.out.println("++++++++++++++++++++++size="+sets.size());
	
	for(int i=0;i<E.length;i++){
		int start = E[i].i;
		int end = E[i].j;
		int counti = -1;
		int countj = -2;
		for(int j=0;j<sets.size();j++){
			HashSet<Integer> set = sets.get(j);
			if (set.contains(start)) {
				counti = j;
			}
			if (set.contains(end)) {
				countj = j;
			}
			if (counti < 0||countj<0) {
				System.err.println("没有在子树中找到节点，错误"); 
			}
		}
		if (counti != countj) {
			 System.out.println("输出start="+start+"||end="+end+"||w="+E[i].w); 
			 HashSet<HashSet> setj = sets.get(countj);
			 sets.remove(countj);
			 HashSet<HashSet> seti = sets.get(counti);
			 sets.remove(counti);
			 seti.addAll(setj);
			 sets.add(seti);
		}
		else {
			System.out.println("他们在一棵子树中，不能输出start="+start+"||end="+end+"||w="+E[i].w);  
		}
	}
}

public static void main(String[] args){
	int [] v={1,2,3,4,5,6}; 
	Edge [] E=new Edge[10];
	E[0]=new Edge(1,2,6);
	E[1]=new Edge(1,3,1);
	E[2]=new Edge(1,4,5);  
    E[3]=new Edge(2,3,5);  
    E[4]=new Edge(2,5,3);  
    E[5]=new Edge(3,4,5);  
    E[6]=new Edge(3,5,6);  
    E[7]=new Edge(3,6,4);  
    E[8]=new Edge(4,6,2);  
    E[9]=new Edge(5,6,6);  
    getMin(v, E);
}
}
