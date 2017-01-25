package offer;

public class FindInArray {
	//最简单的遍历
	 /*public boolean Find(int target, int [][] array) {
		 int rows = array.length;
		 int cols = array[0].length;
		 for(int i = 0; i < rows; i++){
			 for(int j=0;j<cols;j++){
				 if(target == array[i][j]){
					 return true;
				 }
			 }
		 }
		 return false;
	    }*/
	 public boolean Find(int target, int [][] array) {
		 int rows = array.length;
		 int cols = array[0].length;
		 if(rows > 0 && cols > 0){
			 int row = 0;
			 int col = cols -1;
			 while(row <rows && col >= 0){
				if(array[row][col] == target){
					return true;
				}
				else if(array[row][col] > target){
					col--;
				} 
				else if(array[row][col] < target){
					row++;
				}
			 }
		 }
		 return false;
	 }
	 
	 public static void main(String[] args){
		 int[][] array= {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
		 System.out.println(new FindInArray().Find(16, array));
	 }
}
