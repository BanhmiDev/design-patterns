import java.util.ArrayList;

abstract class Component {
	void operation() {};
}

class Composite extends Component {
	ArrayList<Component> children;

	Composite() {
		children = new ArrayList<Component>();
	}

	void operation() {
		for (int i = 0; i < children.size(); i++) {
			children.get(i).operation();
		}
	}

	void addChild(Component component) {
		children.add(component);
	}

	void removeChild(Component component) {
		children.remove(component);
	}

	Component getChildObject(int n) {
		return children.get(n);
	}
}

class ObjectOne extends Component {
	void operation() {
		System.out.println("I'm object one!");
	}
}

class ObjectTwo extends Component {
	void operation() {
		System.out.println("I'm object two!");
	}
}

public class Client {
    public static void main(String[] args) {
    	Composite comp = new Composite();
    	ObjectOne objectOne = new ObjectOne();
    	ObjectTwo objectTwo = new ObjectTwo();

    	System.out.println("----- adding object one -----");
    	comp.addChild(objectOne);
    	comp.operation();
    	System.out.println("----- adding object two -----");
    	comp.addChild(objectTwo);
    	comp.operation();
    	System.out.println("----- removing object one -----");
    	comp.removeChild(objectOne);
    	comp.operation();

		System.out.println("----- adding object one to new composite -----");
    	Composite comp2 = new Composite();
    	comp2.addChild(objectOne);

    	System.out.println("----- adding that composite to the first composite -----");
    	comp.addChild(comp2);
    	comp.operation();
    	// ...
    }
}
