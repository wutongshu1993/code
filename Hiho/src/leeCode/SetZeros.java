package leeCode;

import java.util.HashSet;
import java.util.Set;

/**
 * 如果一个元素是0，把它所在行和所在列所有元素都设置为0,注意，需要先遍历整个数组，看看哪些位置有0。
 * 如[0,0,0,3]则需要把第一行和第一列，第二列，第三列都要置0
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
		for (int k : rowSet) {// 遍历一个set
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
