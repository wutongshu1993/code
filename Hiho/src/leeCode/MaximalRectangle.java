package leeCode;

public class MaximalRectangle {
	/**
	 * ����Ǽ��㽫����Ϊ1��Ԫ�ذ�Χ�ľ��ε����������ɵ���˼���ҳ�����һ�����Σ���������Ԫ�ض�Ϊ1
	 * �����ˡ�����
	 * @param matrix
	 * @return
	 */
public int maximalRectangle(char[][] matrix) {
    if (matrix==null || matrix.length==0) {
		return 0;
	}
	int m = matrix.length;
    int n = matrix[0].length;
    int left_top = m-1;
    int left_down = 0;
    int right_top = n-1;
    int right_down = 0;
    int rect = 0;
    int flag=0;
    for(int i=0;i<m;i++){
    	for(int j=0;j<n;j++){
    		if (matrix[i][j]=='1') {
    			left_top = Math.min(left_top, i);
    			left_down = Math.max(left_down, i);
    			right_top = Math.min(right_top, j);
    			right_down = Math.max(right_down, j);
    			flag = 1;
			}
    		
    	}
    }
    if (flag==1) {
    	 rect = (left_down-left_top+1)*(right_down-right_top+1);
    		return rect;
	}
   return 0;
    }
public static void main(String[] args){
	char[][] matrix = {
			{'0','1','0','0'},
			{'1','0','1','0'},
			{'0','1','0','0'},
			{'0','0','1','1'}};
	System.out.println(new MaximalRectangle().maximalRectangle(matrix));
}
}
