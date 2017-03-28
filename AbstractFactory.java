abstract class AbstractProductA {
	abstract void print();
}

abstract class AbstractProductB {
    abstract void print();
}

class ProductA1 extends AbstractProductA {
	void print() {
		System.out.println("I'm product A1"):
	}
}

class ProductA2 extends AbstractProductA {
	void print() {
		System.out.println("I'm product A2"):
	}
}

class ProductB1 extends AbstractProductB {
	void print() {
		System.out.println("I'm product B1"):
	}
}

class ProductB2 extends AbstractProductB {
	void print() {
		System.out.println("I'm product B2"):
	}
}

abstract class AbstractFactory {
	abstract AbstractProductA createProductA();
	abstract AbstractProductB createProductB();
}

class ConcreteFactory1 extends AbstractFactory {
	AbstractProductA createProductA() {
		return new ProductA1();
	}

	AbstractProductB createProductB() {
		return new ProductB1();
	}
}

class ConcreteFactory2 extends AbstractFactory {
	AbstractProductA createProductA() {
		return new ProductA2();
	}

	AbstractProductB createProductB() {
		return new ProductB2();
	}
}

class Client {
	static void main(String[] args) {
		AbstractFactory factory = new ConcreteFactory1();
		factory.createProductA().print();
		factory = new ConcreteFactory2();
		factory.createProductA().print();
		// ...
	}
}