package leeCode;

public class LengthOfLastWord {
public int lengthOfLastWord(String s) {
    if (s.trim().length()<=1) {
		return s.trim().length();
	}
    
    else {
    	String[] arr = s.split(" ");
        int size = arr.length;
        String temp = arr[size-1];
    	return temp.length(); 
	}
	
    }

public static void main(String[] args){
	System.out.println(new LengthOfLastWord().lengthOfLastWord(" "));
}
}
