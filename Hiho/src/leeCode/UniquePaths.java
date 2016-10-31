package leeCode;
/**
 * 从右上角走到左下角，一共有多少种走法
 * @author lh
 *
 */
public class UniquePaths {
	 public int uniquePaths(int m, int n) {
	     int[][] a = new int[m][n];
	     for(int i=0;i<n;i++){
	    	 a[0][i] = 1;
	     }
	     for(int i=0;i<m;i++){
	    	 a[i][0] = 1;
	     }
	     for(int i=1;i<m;i++){
	    	 for(int j=1;j<n;j++){
//	    		 a[i][j] = a[0][1] * a[i][j-1] + a[1][0] * a[i-1][j];
	    		 a[i][j] = a[i][j-1] +a[i-1][j];
	    	 }
	     }
		 return a[m-1][n-1]; 
	    }
	 /**
	  * 同样是从左上走到右下角，不同的是用数组作为参数，1表示当前为障碍物，0表示可以通过
	  * @param a
	  * @return
	  */
	 public int uniquePathsWithObstacles(int [][] obstacleGrid){
		 int m = obstacleGrid.length;//行数
		 int n = obstacleGrid[0].length;//列数
		 int[][] a = new int[m][n];
		 a[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
		 for(int i=1;i<n;i++){
			 a[0][i] = obstacleGrid[0][i]==1 ? 0 : a[0][i-1];
		 }
		 for(int i=1;i<m;i++){
			 a[i][0] = obstacleGrid[i][0]== 1 ? 0 : a[i-1][0];
		 }
		 for(int i = 1;i<m;i++)
			 for(int j=1;j<n;j++){
				 a[i][j] = obstacleGrid[i][j]==1 ? 0 : a[i-1][j] + a[j-1][i];
			 }
		 return a[m-1][n-1];
	 }
	 public static void main(String[] args){
		 System.out.println(new UniquePaths().uniquePaths2(3, 4));
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 public int uniquePaths2(int m, int n) {
	     int[][] dp = new int[m][n];
	     //初始化
	     for(int i = 0; i < m; i++){
	    	 dp[i][0] = 1;
	     }
	     for(int j = 0; j < n; j++){
	    	 dp[0][j] = 1;
	     }
	     for(int i = 1; i < m; i++){
	    	 for(int j = 1; j < n; j++){
	    		 dp[i][j] = dp[i][j-1]+ dp[i-1][j];
	    	 }
	     }
		 return dp[m-1][n-1];
	    } 
	 
}
