package offer;

import java.util.ArrayList;
import java.util.List;
/**
 * ����һ�����󣬰��մ���������˳ʱ���˳�����δ�ӡ��ÿһ������
 * @author lh
 *
 */
public class PrintMetricClockwise {
	public ArrayList<Integer> printMatrix(int [][] matrix) {
	    int rows = matrix.length;
	    int cols = matrix[0].length;
	    int start = 0;
	    ArrayList<Integer> list = new ArrayList<>();
	    if(matrix == null || rows == 0 || cols == 0){
	    	return null;
	    }
	    while(start * 2 < rows && start * 2 < cols){
	    	printCircle(list, start, matrix);
	    	start++;
	    }
	    
		return list;
    }
	public void printCircle(ArrayList<Integer> list, int start, int[][] matrix){
		int rows = matrix.length;
		int cols = matrix[0].length;
		int endX = cols -1 - start;
		int endY = rows - 1 - start;
		//��������ѭ���ı�
		for(int i = start; i < cols - start; i++){
			list.add(matrix[start][i]);
		}
		//����
		if(start < endY){
			for(int i = start + 1; i < rows - start; i++){
				list.add(matrix[i][cols - start - 1]);
			}
		}
		//����
		if(start < endY && start < endX){
			for(int i = cols - start - 2; i >= start; i--){
				list.add(matrix[rows - start - 1][i]);
			}
		}
		//����
		if(start < endX && start < endY - 1){
			for(int i = rows - start - 2; i > start; i--){
				list.add(matrix[i][start]);
			}
		}
	}
	
	public static void main(String[] args){
		int [][] matrix = {{1,2},{3,4}};
		ArrayList<Integer> list = new PrintMetricClockwise().printMatrix(matrix);
		System.out.println(list);
	}
}
