package leeCode;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *给一个矩阵顶端和左端代表太平洋，右端和底端代表大西洋，每个单元的河水可以四个方向走，但
 *只能流向小于等于它的单元，输出哪些单元既可以流向太平洋，也可以流向大西洋。
 *坑爹的，流到新的单元格了以后值会发生变化，会更新为当前的单元格的值
Example:

Given the following 5x5 matrix:

  Pacific ~   ~   ~   ~   ~ 
       ~  1   2   2   3  (5) *
       ~  3   2   3  (4) (4) *
       ~  2   4  (5)  3   1  *
       ~ (6) (7)  1   4   5  *
       ~ (5)  1   1   2   4  *
          *   *   *   *   * Atlantic

Return:

[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).
 * @author lh
 *
 */
public class PacificAtlantic {
	public List<int[]> pacificAtlantic(int[][] matrix) {
        
		List<int[]> res = new ArrayList<>();
		if (matrix.length == 0) {
			return res;
		}
		int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n]; 
		for(int i = 0; i < m; i++){
        	for(int j = 0; j < n; j++){
        		boolean[] flag = new boolean[2];
        		dfs(i, j,matrix[i][j], matrix, flag, visited);
        		if (flag[0] && flag[1]){
        			int[] temp = {i, j};
        			res.add(temp);
        		}
        	}
        }
		return res;
    }
	
	public void dfs(int i, int j, int val, int[][] matrix, boolean[] flag, boolean[][] visited ){
		if(matrix[i][j] > val)
		{
			return;
		}
		
		if(i <= 0 || j <= 0 ){
			flag[0] = true;
			
		}
		if(i>= matrix.length - 1 || j >= matrix[0].length - 1){
			flag[1] = true;
		}
		if(flag[0] && flag[1] ){
			return;
		}
		if(!visited[i][j] && i > 0 && val >= matrix[i-1][j] ){
			visited[i][j] = true;
			dfs(i - 1, j, matrix[i - 1][j], matrix, flag, visited);
			visited[i][j] = false;
		}
		if(!visited[i][j] && j < matrix[0].length - 1 && val >= matrix[i][j+1] ){
			visited[i][j] = true;
			dfs(i, j + 1, matrix[i][j+1], matrix, flag, visited);
			visited[i][j] = false;
		}
		if(!visited[i][j] && i < matrix.length - 1 && val >= matrix[i+1][j] ){
			visited[i][j] = true;
			dfs(i + 1, j, matrix[i+1][j], matrix, flag, visited);
			visited[i][j] = false;
		}
	
		if(!visited[i][j] && j > 0  && val >= matrix[i][j - 1]){
			visited[i][j] = true;
			dfs(i, j - 1, matrix[i][j-1], matrix, flag, visited);
			visited[i][j] = false;
		}
		
	}
	public static void main(String[] args){
		int[][] matrix = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},
				{6,7,1,4,5},{5,1,1,2,4}};
		System.out.println(new PacificAtlantic().pacificAtlantic(matrix).toString());
	}
}
