package leeCode;
/**
 * ������Ϸ��һ��m*n�����飬ÿ��������0,1����ֵ��ÿ��������8�����ڵĸ��ӣ�
 * ��������ӵ���һ��״̬
 * ����Ҫ��
 * �����ϸ������Χ������������ϸ������ϸ����ȥ
 * �����ϸ����Χ��2��3����ϸ�������뵽��һ������
 * �����ϸ����Χ����3����ϸ������ȥ��
 * �����ϸ����Χ��3����ϸ�������
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
		    		 if (i-1>=0 && j-1>=0) {//����
						if (board[i-1][j-1] == 1) {
							num++;
						}
					}
		    		 if (i-1>=0) {//��
						if (board[i-1][j]==1) {
							num++;
						}
					}
		    		 if (i-1>=0&&j+1<n) {//����
							if (board[i-1][j+1]==1) {
								num++;
							}
					} 
		    		 if (j-1>=0) {//��
							if (board[i][j-1]==1) {
								num++;
							}
					}
		    		 if (i+1<m&&j-1>=0) {//����
							if (board[i+1][j-1]==1) {
								num++;
							}
					}
		    		 if (i+1<m) {//��
							if (board[i+1][j]==1) {
								num++;
							}
					}
		    		 if (i+1<m&&j+1<n) {//����
							if (board[i+1][j+1]==1) {
								num++;
							}
					}
		    		 if (j+1<n) {//��
							if (board[i][j+1]==1) {
								num++;
							}
					}
		    		 //�ж����ĸ��Զ���״̬,��״̬���뵽status��������
		    		 if (board[i][j]==1) {
						if (num<2) {//��ϸ������Χ��ϸ����������2�����ɻ�->����4��
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
		   //����
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
