/*package util;

import java.util.Vector;

*//**
 * δ���
 * @author lh
 *
 *//*
public class Graph {
int vertexNum;
Vector<Integer>[] vector ;//�ڽ������ʾ��
int[] visited;
Stack stack;
Stack result;
Queue queue;
public Graph(int num){
	vertexNum = num;
	vector = new Vector[vertexNum];
	visited = new int[vertexNum];
	for(int i=0;i<vertexNum;i++){
		visited[i] = 0;
	}
	stack = new Stack(num);
	result = new Stack(num);
	queue = new Queue(num);
}
public boolean addEdge(int I, int J){
	if (I == J) {//�û��������ͬһ������
		return false;
	}
	*//**
	 * �ж�����Ķ����Ƕ���ͼ����ʾ���㷶Χ�ڣ�������ڣ�����ʾ
	 *//*
	if (I < vertexNum && J <vertexNum && I>=0 && J>=0) {
		int k;
//		if (I > J) {//ʹi<j
//			k = I;
//			I = J;
//			J = k;
//		}
		*//**
		 * �жϱ��Ƿ����
		 *//*
		if (isEdgeExists(I, J)) {
			return false;
		}
		*//**
		 * ��ӱ�
		 *//*
		try{
		vector[I].add(J);
		}
		catch(Exception e){
			System.err.println(e);
		}
		return true;
	}
	return false;
}
*//**
 * �жϱ��Ƿ����
 * @param i
 * @param j
 * @return
 *//*
public boolean isEdgeExists(int i, int j){
	if(i<vertexNum && j<vertexNum && i>=0 &&j>=0){
		return false;
	}
	*//**
	 * �ж�i���ڽӵ㼯�Ƿ�Ϊ��
	 *//*
	if (vector[i] == null) {
		vector[i] = new Vector(8);
	}
	*//**
	 * �ж��������Ƿ���ڣ�������ڣ�����ʾ���Ѿ�����
	 *//*
	for(int q=0;q<vector[i].size();q++){
		if (((Integer)vector[i].get(q)).intValue() == j) {
			 System.out.println("����" + i + "��" + "����" + j + "������֮����ڱ�");
			 return true;
		}
	}
	return false;
}
public Stack getResult(){
	return result;
}
*//**
 * �õ�ָ���ڵ�ĵ�һ��δ�����ʵ��ڽӵ�λ��
 * @param v
 * @return
 *//*
public int getAdjUnvisitedVertex(int v){
	int temp;
	if (vector[v] != null) {
		for(int j=0;j<vector[v].size();j++)
		{
			temp = ((Integer)vector[v].get(j)).intValue();
			if (visited[temp] == 0) {
				return ((Integer)vector[v].get(j)).intValue();
			}
		}
	}
	return 0;
}
public void dfs(){
	*//**
	 * �Ӷ���0��ʼ����
	 *//*
	visited[0]=1;
	stack.push(0);
	while(!stack.isEmpty()){
		int v =getAdjUnvisitedVertex(stack.peek());
		*//**
		 * û�ҵ�δ�����ʵ��ڽӵ㣬Ԫ�س�ջ������ҵ��Ļ�������������Ϊ���ʹ�������δ�����ʵ�
		 * �ڽӵ���ջ
		 *//*
		if (v == -1) {
			result.push(stack.peek());
			stack.pop();
		}
		else {
			visited[v] = 1;
			stack.push(v);
		}
	}
	System.out.println("����������ȵı���˳��Ϊ��");  
    result.list();  
}
public static void main(String[] args){
	Graph graph = new Graph(6);  
    graph.addEdge(0, 1);  
    graph.addEdge(0, 5);  
    graph.addEdge(0, 2);  
    graph.addEdge(1, 2);  
    graph.addEdge(2, 3);  
    graph.addEdge(1, 4);  
    graph.addEdge(2, 4);  
      
    graph.dfs(); 
}
}
*/
package util;

import java.util.Vector;

/**
 * 
 * @author nishiting
 * 
 */

public class Graph {

	int vertexNum;
	Vector[] vector;
	int[] visited;
	Stack stack;
	Stack result;
	Queue queue;

	/**
	 * 
	 * ����һ��ͼ
	 * 
	 * @param num
	 *            ͼ�Ķ�����
	 * 
	 */
	public Graph(int num) {

		vertexNum = num;
		vector = new Vector[vertexNum];

		visited = new int[vertexNum];
		for (int i = 0; i < num; i++) {
			visited[i] = 0;
		}
		stack = new Stack(num);
		result = new Stack(num);
		queue = new Queue(num);

	}

	/**
	 * ��ͼ����������
	 * 
	 * @param I
	 *            �ߵ�һ������
	 * @param J
	 *            �ߵ���һ������
	 * @return �Ƿ���ӳɹ�
	 */
	public boolean addEdge(int I, int J) {

		/**
		 * �ж��û�������Ƿ���һ�����㣬����ǣ��򷵻�flase,��Ӳ��ɹ�
		 */
		if (J == I) {
			return false;
		}

		/**
		 * �ж�������Ķ���ֵ�Ƿ���ͼ�����㷶Χֵ�ڣ�������ڣ�����ʾ���㲻����
		 * 
		 */
		if (I < vertexNum && J < vertexNum && I >= 0 && J >= 0) {

			int k;
			
			/**
			 * ���i��j����i��j����
			 */

			if (I > J) {
				k = I;
				I = J;
				J = k;
			}

			/**
			 * 
			 * �жϱ��Ƿ����
			 */

			if (isEdgeExists(I, J)) {

				return false;
			}
			
			/**
			 * ��ӱ�
			 */

			vector[I].add(J);
			return true;
		}
		return false;
	}

	/**
	 * �ж�������Ƿ����
	 * 
	 * @param i
	 *            Ҫ��ѯ������ߵ�һ������
	 * @param j
	 *            Ҫ��ѯ������ߵ���һ������
	 * @return ���Ƿ���ڣ�false:�����ڣ�true:����
	 */

	public boolean isEdgeExists(int i, int j) {

		/**
		 * �ж�������Ķ���ֵ�Ƿ���ͼ�����㷶Χֵ�ڣ�������ڣ�����ʾ���㲻����
		 * 
		 */
		if (i < vertexNum && j < vertexNum && i >= 0 && j >= 0) {

			if (i == j) {
				return false;
			}

			int k;

			/**
			 * ���i��j��Ļ���i��j���н���
			 */

			if (i > j) {
				k = i;
				i = j;
				j = k;
			}

			/**
			 * �ж�i���ڽӽ�㼯�Ƿ�Ϊ��
			 */

			if (vector[i] == null) {
				vector[i] = new Vector(8);
			}

			/**
			 * �ж��������Ƿ���ڣ�������ڣ�����ʾ���Ѿ�����
			 */
			for (int q = 0; q < vector[i].size(); q++) {

				if (((Integer) vector[i].get(q)).intValue() == j) {
					System.out.println("����" + i + "��" + "����" + j + "������֮����ڱ�");
					return true;

				}
			}
		}
		return false;
	}

	/**
	 * ����������ȱ���
	 */
	public void dfs() {
		
		/**
		 * �Ӷ���0��ʼ����
		 */

		visited[0] = 1;
		stack.push(0);
		
		/**
		 * ���ջ��Ϊ�յĻ�������ѭ����ѯ
		 */

		while (!stack.isEmpty()) {

			int v = getAdjUnvisitedVertex(stack.peek());
			
			/**
			 * û�ҵ�δ�����ʵ��ڽӵ㣬Ԫ�س�ջ������ҵ��Ļ�������������Ϊ���ʹ�������δ�����ʵ��ڽӵ���ջ
			 */

			if (v == -1) {
				result.push(stack.peek());
				stack.pop();

			} else {
				visited[v] = 1;
				stack.push(v);

			}
		}

		System.out.println("����������ȵı���˳��Ϊ��");
		result.list();

	}
	
	/**
	 * ���й�����ȱ���
	 */
	
	public void bsf(){
		
		/**
		 * �Ӷ���0��ʼ����
		 */
		visited[0] = 1;
		queue.push(0);
		
		while(!queue.isEmpty()){
			int v = queue.pop();
			result.push(v);
			int i;
			while((i = getAdjUnvisitedVertex(v))!=-1){
				visited[i]=1;
				queue.push(i);
			}
			
		}
		System.out.println("������ȵı���˳��Ϊ��");
		result.list();
		
	}

	/**
	 * �õ�ָ������һ��δ�����ʵ��ڽӵ�λ��
	 * 
	 * @param v
	 *            Ҫ��ѯ�Ķ���
	 * @return �������һ��δ�����ʵ��ڽӽ��
	 */

	public int getAdjUnvisitedVertex(int v) {
		int temp;

		/**
		 * �ж��ڽӽ���Ƿ�Ϊ��
		 */

		if (vector[v] != null) {

			/**
			 * �������е��ڽӽ��
			 */
			for (int j = 0; j < vector[v].size(); j++) {
				temp = ((Integer) vector[v].get(j )).intValue();
				/**
				 * �ж��ڽӽ���Ƿ񱻷��ʹ�
				 */
				if (visited[temp] == 0)
					return ((Integer) vector[v].get(j)).intValue();

			}

		}

		return -1;
	}
	
	

	/**
	 * �õ�ͼ�ı���˳��
	 * 
	 * @return ͼ�ı���˳��
	 */

	public Stack getResult() {
		return result;
	}
	public static void main(String[] args){
		Graph graph = new Graph(6);  
	    graph.addEdge(0, 1);  
	    graph.addEdge(0, 5);  
	    graph.addEdge(0, 2);  
	    graph.addEdge(1, 2);  
	    graph.addEdge(2, 3);  
	    graph.addEdge(1, 4);  
	    graph.addEdge(2, 4);  
//	    graph.bsf();
	    graph.dfs(); 
	}

}
