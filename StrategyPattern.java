class Context {
	AbstractStrategy strategy = null;

	void contextInterface() {
		if (strategy != null) {
			strategy.concreteInterface();
		} else {
			System.out.println("Mo strategy set!");
		}
	}

	void setStrategy(AbstractStrategy strategy) {
		this.strategy = strategy;
	}
}

abstract class AbstractStrategy {
	void concreteInterface() {};
}

class ConcreteStrategyOne extends AbstractStrategy {

	@Override
	void concreteInterface() {
		System.out.println("Using strategy one...");
	}
}

class ConcreteStrategyTwo extends AbstractStrategy {

	@Override
	void concreteInterface() {
		System.out.println("Using strategy two...");
	}
}

public class Client {
    public static void main(String[] args) {
    	Context con = new Context();
    	con.contextInterface();

    	con.setStrategy(new ConcreteStrategyOne());
    	con.contextInterface();

    	con.setStrategy(new ConcreteStrategyTwo());
    	con.contextInterface();
    }
}
