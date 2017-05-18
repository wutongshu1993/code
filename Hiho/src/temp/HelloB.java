package temp;

class HelloA {
	public HelloA() {
		System.out.println("I'm A class ");
	}

	static {
		System.out.println("static A");
	}
}

public class HelloB  extends HelloA{
	public HelloB() {
		System.out.println("I'm B class");
	}
	int[] a = {1,2,3};
	static int b = 1;
	static {
		System.out.println("static B");
	}

	Class[] classes = { HelloA.class };

	public static void main(String[] args) throws ClassNotFoundException {
		 HelloB b1 = new HelloB();
		 int[] a = b1.a;
		 a[1] = 99;
		 b1.b = 9;
		 HelloB b2 = new HelloB();
		 System.out.println(a);
		 System.out.println(b2.a);
		 System.out.println(b2.b);
		System.out.println("hello");
	}
}
