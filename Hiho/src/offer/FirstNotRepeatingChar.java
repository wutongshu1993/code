package offer;

import java.util.HashMap;
import java.util.HashSet;

public class FirstNotRepeatingChar {
	 public int FirstNotRepeatingChar(String str) {
	     char[] cs = str.toCharArray();
	     HashMap<Character, Integer> map = new HashMap();
	     for(int i = 0; i < cs.length; i++){
	    	 if (map.get(cs[i]) == null) {//²»´æÔÚ
				map.put(cs[i], 1);
			}
	    	 else {
	    		 map.put(cs[i], 2);;
			}
	     }
	     for(int i = 0; i< cs.length; i++){
	    	 if(map.get(cs[i]) == 1){
	    		 return i;
	    	 }
	     }
	    
	     
		 return -1;
	    }
	 public static void main(String[] args){
		 int n = new FirstNotRepeatingChar().FirstNotRepeatingChar("google");
		 System.out.println(n);
	 }
}
