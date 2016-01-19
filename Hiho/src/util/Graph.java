/*package util;

import java.util.Vector;

*//**
 * 未完成
 * @author lh
 *
 *//*
public class Graph {
int vertexNum;
Vector<Integer>[] vector ;//邻接链表表示法
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
	if (I == J) {//用户输入的是同一个顶点
		return false;
	}
	*//**
	 * 判断输入的顶点是都在图的所示顶点范围内，如果不在，则提示
	 *//*
	if (I < vertexNum && J <vertexNum && I>=0 && J>=0) {
		int k;
//		if (I > J) {//使i<j
//			k = I;
//			I = J;
//			J = k;
//		}
		*//**
		 * 判断边是否存在
		 *//*
		if (isEdgeExists(I, J)) {
			return false;
		}
		*//**
		 * 添加边
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
 * 判断边是否存在
 * @param i
 * @param j
 * @return
 *//*
public boolean isEdgeExists(int i, int j){
	if(i<vertexNum && j<vertexNum && i>=0 &&j>=0){
		return false;
	}
	*//**
	 * 判断i的邻接点集是否为空
	 *//*
	if (vector[i] == null) {
		vector[i] = new Vector(8);
	}
	*//**
	 * 判断这条边是否存在，如果存在，则提示边已经存在
	 *//*
	for(int q=0;q<vector[i].size();q++){
		if (((Integer)vector[i].get(q)).intValue() == j) {
			 System.out.println("顶点" + i + "和" + "顶点" + j + "这两点之间存在边");
			 return true;
		}
	}
	return false;
}
public Stack getResult(){
	return result;
}
*//**
 * 得到指定节点的第一个未被访问的邻接点位置
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
	 * 从顶点0开始遍历
	 *//*
	visited[0]=1;
	stack.push(0);
	while(!stack.isEmpty()){
		int v =getAdjUnvisitedVertex(stack.peek());
		*//**
		 * 没找到未被访问的邻接点，元素出栈，如果找到的话，将这个结点标记为访问过，将其未被访问的
		 * 邻接点入栈
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
	System.out.println("进行深度优先的遍历顺序为：");  
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
	 * 构造一个图
	 * 
	 * @param num
	 *            图的顶点数
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
	 * 向图中添加无向边
	 * 
	 * @param I
	 *            边的一个顶点
	 * @param J
	 *            边的另一个顶点
	 * @return 是否添加成功
	 */
	public boolean addEdge(int I, int J) {

		/**
		 * 判断用户输入的是否是一个顶点，如果是，则返回flase,添加不成功
		 */
		if (J == I) {
			return false;
		}

		/**
		 * 判断所输入的顶点值是否在图所顶点范围值内，如果不在，则提示顶点不存在
		 * 
		 */
		if (I < vertexNum && J < vertexNum && I >= 0 && J >= 0) {

			int k;
			
			/**
			 * 如果i比j大，则将i与j交换
			 */

			if (I > J) {
				k = I;
				I = J;
				J = k;
			}

			/**
			 * 
			 * 判断边是否存在
			 */

			if (isEdgeExists(I, J)) {

				return false;
			}
			
			/**
			 * 添加边
			 */

			vector[I].add(J);
			return true;
		}
		return false;
	}

	/**
	 * 判断无向边是否存在
	 * 
	 * @param i
	 *            要查询的无向边的一个顶点
	 * @param j
	 *            要查询的无向边的另一个顶点
	 * @return 边是否存在，false:不存在，true:存在
	 */

	public boolean isEdgeExists(int i, int j) {

		/**
		 * 判断所输入的顶点值是否在图所顶点范围值内，如果不在，则提示顶点不存在
		 * 
		 */
		if (i < vertexNum && j < vertexNum && i >= 0 && j >= 0) {

			if (i == j) {
				return false;
			}

			int k;

			/**
			 * 如果i比j大的话，i与j进行交换
			 */

			if (i > j) {
				k = i;
				i = j;
				j = k;
			}

			/**
			 * 判断i的邻接结点集是否为空
			 */

			if (vector[i] == null) {
				vector[i] = new Vector(8);
			}

			/**
			 * 判断这条边是否存在，如果存在，则提示边已经存在
			 */
			for (int q = 0; q < vector[i].size(); q++) {

				if (((Integer) vector[i].get(q)).intValue() == j) {
					System.out.println("顶点" + i + "和" + "顶点" + j + "这两点之间存在边");
					return true;

				}
			}
		}
		return false;
	}

	/**
	 * 进行深度优先遍历
	 */
	public void dfs() {
		
		/**
		 * 从顶点0开始遍历
		 */

		visited[0] = 1;
		stack.push(0);
		
		/**
		 * 如果栈不为空的话，进行循环查询
		 */

		while (!stack.isEmpty()) {

			int v = getAdjUnvisitedVertex(stack.peek());
			
			/**
			 * 没找到未被访问的邻接点，元素出栈，如果找到的话，将这个结点标记为访问过，将其未被访问的邻接点入栈
			 */

			if (v == -1) {
				result.push(stack.peek());
				stack.pop();

			} else {
				visited[v] = 1;
				stack.push(v);

			}
		}

		System.out.println("进行深度优先的遍历顺序为：");
		result.list();

	}
	
	/**
	 * 进行广度优先遍历
	 */
	
	public void bsf(){
		
		/**
		 * 从顶点0开始遍历
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
		System.out.println("广度优先的遍历顺序为：");
		result.list();
		
	}

	/**
	 * 得到指定结点的一个未被访问的邻接点位置
	 * 
	 * @param v
	 *            要查询的顶点
	 * @return 顶点的下一个未被访问的邻接结点
	 */

	public int getAdjUnvisitedVertex(int v) {
		int temp;

		/**
		 * 判断邻接结点是否为空
		 */

		if (vector[v] != null) {

			/**
			 * 遍历所有的邻接结点
			 */
			for (int j = 0; j < vector[v].size(); j++) {
				temp = ((Integer) vector[v].get(j )).intValue();
				/**
				 * 判断邻接结点是否被访问过
				 */
				if (visited[temp] == 0)
					return ((Integer) vector[v].get(j)).intValue();

			}

		}

		return -1;
	}
	
	

	/**
	 * 得到图的遍历顺序
	 * 
	 * @return 图的遍历顺序
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
