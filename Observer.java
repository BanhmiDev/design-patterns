import java.util.ArrayList;

abstract class AbstractSubject {

    private ArrayList<AbstractObserver> observers = new ArrayList<AbstractObserver>();

    void register(AbstractObserver o) {
        observers.add(o);
    }

    void unregister(AbstractObserver o) {
        observers.remove(o);
    }

    void notifyObservers() {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).refresh(); // Observers should refresh the state of their viewed object
        }
    }

    Object getSubjectState() { return null; };
    void setSubjectState(Object subjectState) {};
}

class ConcreteSubject extends AbstractSubject {
    private Object subjectState;

    @Override
    Object getSubjectState() {
        return subjectState;
    }

    @Override
    void setSubjectState(Object subjectState) {
        System.out.println("Subject changing!");
        this.subjectState = subjectState;
        notifyObservers();
    }
}

abstract class AbstractObserver {
    void refresh() {};
}

class ConcreteObserver extends AbstractObserver {
    private AbstractSubject subject;
    private Object observerState;

    ConcreteObserver(AbstractSubject subject) {
        this.subject = subject;
    }

    @Override
    void refresh() {
        if (subject != null) {
            System.out.println("Refreshed for observer!");
            observerState = subject.getSubjectState();
        }
    }
}

public class Client {
    public static void main(String[] args) {
        ConcreteSubject mainSubject = new ConcreteSubject();
        ConcreteObserver observerOne = new ConcreteObserver(mainSubject);
        ConcreteObserver observerTwo = new ConcreteObserver(mainSubject);
        mainSubject.register(observerOne);
        mainSubject.register(observerTwo);
        mainSubject.setSubjectState(new Object());
        mainSubject.setSubjectState(new Object());
    }
}
