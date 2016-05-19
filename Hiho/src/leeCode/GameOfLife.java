package leeCode;
/**
 * 生命游戏，一个m*n的数组，每个格子有0,1两个值，每个格子有8个相邻的格子；
 * 计算出格子的下一个状态
 * 计算要求：
 * 如果活细胞，周围有少于两个活细胞，该细胞死去
 * 如果活细胞周围有2或3个活细胞，进入到下一个周期
 * 如果活细胞周围大于3个活细胞，死去。
 * 如果死细胞周围有3个活细胞，复活。
 * 0->0 1
 * 1->1 2
 * 0->1 3
 * 1->0 4
 * @author lh
 *
 */
public class GameOfLife {
	 public void gameOfLife(int[][] board) {
	     int m = board.length;
	     int n=0;
	     if (board!=null&&board.length > 0) {
	    	n = board[0].length;
	    	int[][] status = new int[m][n];
		     for(int i=0;i<m;i++){
		    	 for(int j=0;j<n;j++){
		    		 int num=0;
		    		 if (i-1>=0 && j-1>=0) {//左上
						if (board[i-1][j-1] == 1) {
							num++;
						}
					}
		    		 if (i-1>=0) {//上
						if (board[i-1][j]==1) {
							num++;
						}
					}
		    		 if (i-1>=0&&j+1<n) {//右上
							if (board[i-1][j+1]==1) {
								num++;
							}
					} 
		    		 if (j-1>=0) {//左
							if (board[i][j-1]==1) {
								num++;
							}
					}
		    		 if (i+1<m&&j-1>=0) {//左下
							if (board[i+1][j-1]==1) {
								num++;
							}
					}
		    		 if (i+1<m) {//下
							if (board[i+1][j]==1) {
								num++;
							}
					}
		    		 if (i+1<m&&j+1<n) {//右下
							if (board[i+1][j+1]==1) {
								num++;
							}
					}
		    		 if (j+1<n) {//右
							if (board[i][j+1]==1) {
								num++;
							}
					}
		    		 //判断是哪个自动机状态,将状态存入到status数组里面
		    		 if (board[i][j]==1) {
						if (num<2) {//活细胞，周围活细胞数量少于2个，由活->死（4）
							status[i][j] = 4;
						}
						else if (num == 2 || num == 3) {
							status[i][j] = 2;
						}
						else if (num > 3) {
							status[i][j] = 4;
						}
					}
		    		 else {
						if (num <3) {
							status[i][j] = 1;
						}
						else if (num == 3) {
							status[i][j] = 3;
						}
					}
		    		 
		    	 }
		     }
		   //更新
		     for(int i=0;i<m;i++){
		    	 for(int j=0;j<n;j++){
		    		 if (status[i][j] == 3) {
						board[i][j] = 1;
					}
		    		 else if (status[i][j] == 4) {
						board[i][j] = 0;
					}
		    	 }
		     }
		}
	     
	    }
	 public static void main(String[] args){
		 int [][] board={};
		 new GameOfLife().gameOfLife(board);
	 }
}
