package leeCode;

import java.util.ArrayList;
import java.util.List;
//完全理解错意思了。。
public class CountAndSay {
	public String countAndSay(int n) {
		char[] nattr = (n + "").toCharArray();
		int num = 1;
		List<Integer> count = new ArrayList<>();
		List<Character> say = new ArrayList<>();
		String s = "";
		int flag=0;
		if (nattr.length==1) {
			return nattr[0]+"";
		}
		else {
			
		
		for (int i = 1; i < nattr.length; i++) {
//			if (i < nattr.length - 1) 
			{
				if (nattr[i] == nattr[i - 1]) {
					num++;
					flag=1;
				} else if(i<nattr.length-1){
					count.add(num);
					say.add(nattr[i-1]);
					num = 1;
					
				}
				if(i==nattr.length-1) {
					count.add(num);
					say.add(nattr[i]);
					num = 1;
				}
				
			} 
			
//			else if(i==nattr.length-1){
//				if (nattr[i]==nattr[i-1]) {
//					num++;
//					count.add(num);
//					say.add(nattr[i]);
//				}
//				else {
//					count.add(num);
//					say.add(nattr[i]);
//				}
//			}
		}
		if (flag==0) {
			count.add(num);
			say.add(nattr[0]);
		}
		for (int i = 0; i < count.size(); i++) {
			s += count.get(i) + "" + say.get(i);
		}
		return s;
		}
	}

	public static void main(String[] args) {
		System.out.println(new CountAndSay().countAndSay(2222));
	}
}
