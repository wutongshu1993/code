package leeCode;

public class NumberOfIslands {
public int numIslands(char[][] grid) {
    if(grid == null || grid.length == 0) return 0;
    int num = 0;
    int row = grid.length;
    int col = grid[0].length;
	boolean[][] visited = new boolean[row][col];    
	for(int i = 0; i < row; i++){
		for(int j = 0; j < col; j++){
			if(grid[i][j] == '1' && !visited[i][j]){
				dfs(i, j, visited, grid);
				num ++;
			}
		}
	}
	return num;
    }
 public void dfs(int x, int y, boolean[][] visited, char[][] grid){
	if(x > grid.length - 1 || y > grid[0].length - 1 || x <0 || y < 0 || visited[x][y] || grid[x][y] == '0'){
		return ;
	}
	visited[x][y] = true;
	dfs(x, y + 1, visited, grid);
	dfs(x + 1, y, visited, grid);
	dfs(x, y - 1, visited, grid);
	dfs(x - 1, y, visited, grid);
 }
 
 public static void main(String[] args){
	 char[][] grid= {
			 {'1','1','1'},
			 {'0','1','0'},
			 {'1','1','1'},
			 };
	System.out.println( new NumberOfIslands().numIslands(grid));;
 }
}
