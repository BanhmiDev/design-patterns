abstract class AbstractSubject {
    void display() {};
}

class RealSubject extends AbstractSubject {

    String text;

    RealSubject(String text) {
        this.text = text;
    }

    void display() {
        System.out.println("I'm the real subject, " + text);
    }
}

class ProxySubject extends AbstractSubject {

    RealSubject realSubject;
    String text;

    ProxySubject(String text) {
        this.text = text;
    }

    void display() {
        if (realSubject == null) {
            realSubject = new RealSubject(text);
        }
        realSubject.display();
    }

}

public class Client {
    public static void main(String[] args) {
        AbstractSubject subject = new ProxySubject("custom text here.");
        subject.display(); // Load from disk
        subject.display(); // Not loaded from disk anymore
    }
}
