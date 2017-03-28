class Service {
    void doSomething() {
        System.out.print("Service doing something ");
    }
}

class AdapterInheritance extends Service implements TargetInterface {
    public void request() {
        doSomething();
        System.out.print("via adapter-inheritance.\n");
    }
}

class AdapterDelegation implements TargetInterface {

    Service service = null;

    AdapterDelegation() {
        service = new Service();
    }

    public void request() {
        service.doSomething();
        System.out.print("via adapter-delegation.\n");
    }
}

interface TargetInterface {
    void request();
}

public class Client {
    public static void main(String[] args) {
        AdapterInheritance adapter = new AdapterInheritance();
        adapter.request();

        AdapterDelegation adapter2 = new AdapterDelegation();
        adapter2.request();
        // ...
    }
}
