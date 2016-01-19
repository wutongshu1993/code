package util;
/**
 * 边的辅助类
 * @author lh
 *
 */
public class Edge implements Comparable<Object> {
public int i,j,w;
/**
 * 
 * @param i 该条边的起点
 * @param j 该条边的终点
 * @param w 该条边的权值
 */
	public Edge(int i, int j, int w) {
	super();
	this.i = i;
	this.j = j;
	this.w = w;
}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		Edge to = (Edge) o;
		if (w>to.w)  return 1;//大于
		else if(w == to.w) return 0;
		else if(w < to.w) return -1;
		return 0;
	}
@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "start="+i+"||end="+j+"||weigh="+w;
	}
}
