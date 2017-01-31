package offer;

import java.util.ArrayList;

public class FindContinuousSequence {
	ArrayList<ArrayList<Integer>> res = new ArrayList<>();
	public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
		int[][] array = new int[(1+sum)/2][(1+sum)/2];
		dp(array, sum);
		return res;   
    }
	public int[][] dp(int[][] array, int sum){
		//≥ı ºªØ
		for(int i = 0; i < array.length; i++){
			array[i][i] = i+1;
		}
		for(int i = 0; i < array.length - 1; i++){
			for(int j = i+1; j < array[0].length; j++){
				if(i == 0){
				array[i][j] = array[i][j-1] + array[j][j];
			}
				else {			
					array[i][j] = array[i-1][j] - array[i-1][i-1];	
					}
				if(array[i][j] == sum){
					ArrayList<Integer> temp = new ArrayList<>();
					for(int k = i; k <= j; k++){
						temp.add(array[k][k]);
					}
					res.add(temp);
				}
			}
			
			
			
		}
		return array;
	}
	public static void main(String[] args){
//		int[][] a = new FindContinuousSequence().dp(new int[6][6]);
		new FindContinuousSequence().FindContinuousSequence(3);
		System.out.println(1);
	}
}
