package leeCode;

/**
 * 给出一个二维数组和字符串，在二维数组中查找能否找到该字符串 [ ['A','B','C','E'], ['S','F','C','S'],
 * ['A','D','E','E'] ]，word = "ABCCED", -> returns true, word = "SEE", ->
 * returns true, word = "ABCB", -> returns false.
 * 
 * @author lh
 *
 */
public class WordSearch {
	// 记录首字母在二维数组中存在的位置
	// private int[] findPosition(char[][] board, char start){
	// int m = board.length;//行数
	// int n = board[0].length;//列数
	// int[] positions = new int[m*n];
	// int pos=0;
	// for(int i=0;i<m;i++)
	// for(int j=0;j<n;j++)
	// {
	// if (board[i][j]==start) {
	// positions[pos++] = (i+1)*n + j+1;
	// }
	// }
	// return positions;
	// }
	// private int[] isAvaliable(char[][] board, int start, char target){
	// int m = board.length;//行数
	// int n = board[0].length;//列数
	// int col = (start-1) / n ;//起始位置的行
	// int row = (start-1)%n ;//起始位置的列
	// int[] position = new int[4];
	// int pos=0;
	// if (col > 0) {//向上
	// if(board[col-1][row] == target){
	// position[pos++] = start - n;
	// }
	// }
	// if (col < m-1) {//向下
	// if (board[col+1][row] == target) {
	// position[pos++] = start + n;
	// }
	// }
	// if (row > 0) {//向左
	// if (board[col][row-1] == target) {
	// position[pos++] = start -1;
	// }
	// }
	// if (row < n-1) {//向右
	// if (board[col][row+1] == target) {
	// position[pos++] = start+1;
	// }
	// }
	// return position;
	// }
	// public boolean exist(char[][] board, String word) {
	// int m = board.length;//行数
	// int n = board[0].length;//列数
	// boolean[] visited = new boolean[m*n];//记录路径，也即是否访问
	// int pos=0;
	// int[] start = findPosition(board, word.charAt(pos++));
	// for(int i=0;i<start.length;i++){
	// int position = start[i];
	// if (position != 0) {
	// visited[position] = true;
	// int[] next = isAvaliable(board, position, word.charAt(pos++));
	// }
	//
	//
	// }
	// return false;
	// }
	public boolean search(char[][] board, int i, int j, String word, boolean[][] visited) {
		int m = board.length;
		int n = board[0].length;
		int[][] direction = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		for (int k = 0; k < direction.length; k++) {
			int ii = i + direction[k][0];
			int jj = j + direction[k][1];
			if (ii >= 0 && ii < m && jj >= 0 && jj < n 
					&& visited[ii][jj] == false 
					&& board[ii][jj] == word.charAt(0)) {
				visited[ii][jj] = true;
				if (word.length() == 1 || search(board, ii, jj, word.substring(1), visited)) {
					return true;
				}
				visited[ii][jj] = false;
				
			}
		}
		return false;
	}

	public boolean exist(char[][] board, String word) {
		if (word.length()==0){
			return false;
		}
		int m = board.length;
		int n = board[0].length;
		boolean [][] visited = new boolean[m][n];
		for(int i=0;i<m;i++)
		for(int j=0;j<n;j++)
		{
			visited[i][j] = false;
		}
		for(int i=0;i<m;i++)
			for(int j=0;j<n;j++){
				if (board[i][j] == word.charAt(0)) {
					visited[i][j] = true;
					if (word.length()==1 || search(board, i, j, word.substring(1), visited)) {
						return true;
					}
					visited[i][j] = false;
				}
				
			}
		return false;
	}
	
	
	public boolean exist2(char[][] board, String word){
		int rows = board.length;
		int cols = board[0].length;
		boolean[][] visited = new boolean[rows][cols];
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < cols; j++){
				if(dfs(board, word, visited, i, j)){
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean dfs(char[][] board, String str, boolean[][] visited, int i, int j ){
		int rows = board.length;
		int cols = board[0].length;
		if(i < rows && j < cols  && i>=0 && j >= 0 && !visited[i][j] && board[i][j] == str.charAt(0)){
			visited[i][j] = true;
			if(str.length() == 1 || dfs(board, str.substring(1), visited, i + 1, j) ){
				return true;
			}
			else if(str.length() == 1 || dfs(board, str.substring(1), visited, i - 1, j)){
				return true;
			}
			else if(str.length() == 1 || dfs(board, str.substring(1), visited, i, j + 1)){
				return true;
			}
			else if(str.length() == 1 || dfs(board, str.substring(1), visited, i, j - 1)){
				return true;
			}
			visited[i][j] = false;
		}
		return false;
	}
	
	public static void main(String[] args){
		char[][] board = {{'C','A','A'},
						  {'A','A','A'},
			              {'B','C','D'}};
		System.out.println(new WordSearch().exist2(board, "AAB"));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
