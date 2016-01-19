package leeCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidAnagram {
public static boolean isAnagram(String s, String t){
	if (s==null && t==null || s==""&& t=="") {
		return true;
	}
	else {
		Arrays sArrays = null;
		char[] cs = s.toCharArray();
		char[] ct = t.toCharArray();
		sArrays.sort(cs);
		sArrays.sort(ct);
		if (cs.length == ct.length) {
			for(int i=0;i<cs.length;i++){
			if (cs[i] == ct[i]) {
				
			}
			else {
				return false;
			}
		}
			return true;	
		}
		return false;
	}
	
	
}
public static void main(String[] args){
	isAnagram("abc", "dba");
}
}
