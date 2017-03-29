abstract class Component {
    void operation() {};
}

class ConcreteComponent extends Component {

    @Override
    void operation() {
        System.out.println("Using concrete component.");
    }
}

class Decorator extends Component {

    Component component; // References to the "smaller" component

    @Override
    void operation() {
        component.operation();
    }
}

class ConcreteDecoratorA extends Decorator {

    private int exampleAttribute;

    @Override
    void operation() {
        component.operation();
        System.out.println("Using decorator a: with additional example attribute.");
    }
}

class ConcreteDecoratorB extends Decorator {
    @Override
    void operation() {
        component.operation();
        exampleMethod();
    }

    void exampleMethod() {
        System.out.println("Using decorator b: with additional example method.");
    }
}

public class Client {
    public static void main(String[] args) {
        System.out.println("----- standalone component -----");
        Component c = new ConcreteComponent();
        c.operation();

        System.out.println("----- adding concrete decorator a to the previous component -----");
        Decorator d = new ConcreteDecoratorA();
        d.component = c;
        c = d;
        c.operation();

        System.out.println("----- removing concrete decorator a from the previous component -----");
        c = ((Decorator)c).component;
        c.operation();

        System.out.println("----- adding concrete decorator a to the main component, concrete decorator b to a -----");
        d.component = c;
        Decorator d2 = new ConcreteDecoratorB();
        d2.component = d;
        c = d2;
        c.operation();
    }
}
