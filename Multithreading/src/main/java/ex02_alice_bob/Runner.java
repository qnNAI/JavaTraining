package ex02_alice_bob;

public class Runner {

    public static void main(String[] args) {
        Person alice = new Person("Alice");
        Person bob = new Person("Bob");

        Thread t1 = new Thread(alice);
        Thread t2 = new Thread(bob);

        t1.start();
        t2.start();

        System.out.println("Main finished");
    }
}
