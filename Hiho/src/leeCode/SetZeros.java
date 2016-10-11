package leeCode;

import java.util.HashSet;
import java.util.Set;

/**
 * ���һ��Ԫ����0�����������к�����������Ԫ�ض�����Ϊ0,ע�⣬��Ҫ�ȱ����������飬������Щλ����0��
 * ��[0,0,0,3]����Ҫ�ѵ�һ�к͵�һ�У��ڶ��У������ж�Ҫ��0
 * 
 * @author lh
 *
 */
public class SetZeros {
	public void setZeroes(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		Set<Integer> rowSet = new HashSet<>();
		Set<Integer> colSet = new HashSet<>();
		for (int i = 0; i < rows; i++) {
			int j = 0;
			while (j < cols) {
				if (matrix[i][j] == 0) {
					rowSet.add(i);
					colSet.add(j);
				}
				j++;
			}
		}
		for (int k : rowSet) {// ����һ��set
			for (int p = 0; p < cols; p++) {
				matrix[k][p] = 0;
			}
		}
		for (int k : colSet) {
			for (int q = 0; q < rows; q++) {
				matrix[q][k] = 0;
			}
		}
	}
}
