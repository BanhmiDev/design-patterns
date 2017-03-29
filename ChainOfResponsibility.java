abstract class AbstractProcessor {

	AbstractProcessor successor = null;

	void setSuccessor(AbstractProcessor successor) {
		this.successor = successor;
	}

	void process(String unit) {};
}

class ConcreteProcessorOne extends AbstractProcessor {

	@Override
	void process(String unit) {
		if (unit == "one") {
			System.out.println("Concrete processor one is responsible for this task!");
		} else if (successor != null) {
			successor.process(unit);
		} else {
			System.out.println("No one is responsible for this task!");
		}
	}
}

class ConcreteProcessorTwo extends AbstractProcessor {

	@Override
	void process(String unit) {
		if (unit == "two") {
			System.out.println("Concrete processor two is responsible for this task!");
		} else if (successor != null) {
			successor.process(unit);
		} else {
			System.out.println("No one is responsible for this task!");
		}
	}
}

public class Client {
    public static void main(String[] args) {
    	ConcreteProcessorOne procOne = new ConcreteProcessorOne();
    	procOne.setSuccessor(new ConcreteProcessorTwo());
    	procOne.process("one");
    	procOne.process("two");
    	procOne.process("something");
    }
}
