package type;

class Test {
	public int value(){
		Outer o = new Outer();
		return o.q;
	}
}
public class Outer {
	private int p = 9;
	public int q = 2;
class Inner {
	private int i = 0;
	public int value() {
		return i;
	}
	public Outer outer(){
		return Outer.this;
	}
}
public Inner inner(){
	return new Inner();
}
public static void main(String[] args){
	Outer o = new Outer();
	o.p = 8;
	Inner i = o.inner();
	Inner i2 = o.new Inner();
	System.out.println(i.outer().p);
	System.out.println(i.i);
	System.out.println(i2.i);
	
}
public void test(){
	Inner i = new Inner();
}
}
