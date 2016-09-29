package hdoj;

import java.io.*;
import java.util.*;


public class Main
{
    public static void main(String args[])
    {
        Scanner cin = new Scanner(System.in);
        String input = "";
//        while(cin.hasNext())
//        {
//            input = cin.nextLine();
//        }
        System.out.println(find("helloworld"));
    }
    
    public static String find(String input){
    	Map<String, Integer> map = new HashMap<>();
    	Map<Integer, String> map2 = new HashMap<>();
    	Map<String, Integer> result = new HashMap<>();
    	String re = "";
    	String bString = "";
    	int index = 0;
    	
    	String[] strs ={"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p"
    			,"q","r","s","t","u","v","w","x","y","z"		
    	}; 
    	for(int i = 0;i<input.length(); i++){
    		if(map.containsKey(input.charAt(i)+"")){
    			int p = map.get(input.charAt(i)+"");
    			String temp2 =map2.get(p);
//    			String qString = result.get
//    			String temp = strs[p];
    			re += temp2;
    		}
    		else{
    			map.put(input.charAt(i)+"", i);
    			map2.put(i, strs[index]);
    			result.put(strs[index], i);
    			re += strs[index];
    			index++;
    		}
    	}
    	
    	return re;
    }
    
    public String valueToKey(HashMap<String, Integer> map, int  p){
    	
    	for(int n: map.values()){
    		if(p == n){
    			
    		}
    		
    	}
    	
    	return null;
    }
}