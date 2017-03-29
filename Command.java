class Caller {
    AbstractCommand command;

    void setCommand(AbstractCommand command) {
        this.command = command;
    }

    void imaginaryClick() {
        if (command != null) command.process();
    }
}

abstract class AbstractCommand {
    void process() {};
}

class ConcreteCommandOne extends AbstractCommand {

    Receiver receiver;

    void process() {
        System.out.println("Called command one...");
        receiver.action();
    }

    void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }
}

class ConcreteCommandTwo extends AbstractCommand {
    void process() {
        System.out.println("Called command two (no additional receiver action, yet)...");
        // ...
    }
}

class Receiver {
    void action() {
        System.out.println("Some receiver action...");
    }
}

public class Client {
    public static void main(String[] args) {
        ConcreteCommandOne cco = new ConcreteCommandOne();
        cco.setReceiver(new Receiver());

        Caller caller = new Caller();
        caller.setCommand(cco);
        caller.imaginaryClick();

        ConcreteCommandTwo cct = new ConcreteCommandTwo();
        caller.setCommand(cct);
        caller.imaginaryClick();

        // ...
    }
}
