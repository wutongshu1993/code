package type;

import java.util.LinkedHashMap;
import java.util.TreeMap;

public class Cols {
public static void main(String[] args) {
	LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
	map.put("b", 1);
	map.put("a", 2);
	System.out.println(map);
	
	TreeMap<String, Integer> map2 = new TreeMap<>();
	map2.put("b", 1);
	map2.put("a", 2);
	System.out.println(map2);
	
	Holder h = new Holder<String>("abc");
	System.err.println(h.getData());
}
}
class Holder<T> {
	private T data;
	public Holder(){}
	public Holder(T data){
		this.data = data;
	}
	T getData() {
		return data;
	}
}
