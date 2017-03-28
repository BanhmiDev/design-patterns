abstract class Abstraction {
    Implementer imp;

    Abstraction(Implementer imp) {
        this.imp = imp;
    }

    void operation() {};
}

interface Implementer {
    public void operationImp();
}


class ConcreteAbstraction extends Abstraction {

    ConcreteAbstraction(Implementer imp) {
        super(imp);
    }

    void operation() {
        imp.operationImp();
    }
}

class ConcreteImplementerA implements Implementer {
    public void operationImp() {
        System.out.println("I'm implementer A");
    }
}

class ConcreteImplementerB implements Implementer {
    public void operationImp() {
        System.out.println("I'm implementer B");
    }
}


public class Client {
    public static void main(String[] args) {
        Abstraction ab = new ConcreteAbstraction(new ConcreteImplementerA());
        ab.operation();

        Abstraction ab2 = new ConcreteAbstraction(new ConcreteImplementerB());
        ab2.operation();
    }
}
