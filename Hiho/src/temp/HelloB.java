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

	static {
		System.out.println("static B");
	}

	Class[] classes = { HelloA.class };

	public static void main(String[] args) throws ClassNotFoundException {
		 new HelloB();
		System.out.println("hello");
	}
}
