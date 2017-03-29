abstract class AbstractClass {
	void templateMethod() {
		System.out.println("Calling template method...");
		operation1();
		operation2();
	}

	void operation1() {};
	void operation2() {};
}

class ConcreteClass extends AbstractClass {

	@Override
	void operation1() {
		System.out.println("Calling operation 1 from concrete class");
	}

	@Override
	void operation2() {
		System.out.println("Calling operation 2 from concrete class");
	}
}

public class Client {
    public static void main(String[] args) {
    	AbstractClass c = new ConcreteClass();
    	c.templateMethod();
    }
}
