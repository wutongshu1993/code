package util;
/**
 * �ߵĸ�����
 * @author lh
 *
 */
public class Edge implements Comparable<Object> {
public int i,j,w;
/**
 * 
 * @param i �����ߵ����
 * @param j �����ߵ��յ�
 * @param w �����ߵ�Ȩֵ
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
		if (w>to.w)  return 1;//����
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
