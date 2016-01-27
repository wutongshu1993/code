package leeCode;

import java.util.ArrayList;
import java.util.List;

public class PasscalTrangle {
public List<List<Integer>> generate(int numRows) {
    
    List<List<Integer>> l = new ArrayList<>() ;
    for(int i=1;i<=numRows;i++){
    	int[] a = new int[i];
    	List<Integer> list = new ArrayList<>();
//    	a[0] = 1;
//    	a[i-1] = 1;
    	int[] b = new int[i];
    	b[0] = 1;
    	b[i-1] = 1;
    	for(int j=1;j<i-1;j++){
    		b[j] = l.get(i-2).get(j-1)+l.get(i-2).get(j);
    	}
    	for(int k=0;k<i;k++){
    		list.add(b[k]);
    	}
    	l.add(list);
    }
	return l;  
    }
 
public List<Integer> getRow(int rowIndex) {
	int numRows = rowIndex+1;
	List<Integer> l2 = new ArrayList<>();
	l2.add(1);
	List<List<Integer>> l = new ArrayList<>() ;
    for(int i=1;i<=numRows;i++){
    	List<Integer> list = new ArrayList<>();
    	int[] b = new int[i];
    	b[0] = 1;
    	b[i-1] = 1;
    	for(int j=1;j<i-1;j++){
    		b[j] = l.get(i-2).get(j-1)+l.get(i-2).get(j);
    	}
    	for(int k=0;k<i;k++){
    		list.add(b[k]);
    	}
    	l.add(list);
    }
    if (rowIndex > 0) {
		l2 = l.get(rowIndex);
	}
	return l2;  
     
    } 
public static void main(String[] args){
	 List<Integer> l = new PasscalTrangle().getRow(4);
}
}