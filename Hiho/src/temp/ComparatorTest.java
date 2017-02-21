package temp;

import java.util.Comparator;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;

public class ComparatorTest {

public static void main(String[] args){
	TreeMap<String, Integer> map = new TreeMap<>(new Comparator<String>() {
		
		@Override
		public int compare(String o1, String o2) {
			// TODO Auto-generated method stub
			return o2.compareTo(o1) ;
		}
	});
	Hashtable<String, Integer> table;
	map.put("a", 1);
	map.put("b", 2);
	System.err.println(1);
}
}
