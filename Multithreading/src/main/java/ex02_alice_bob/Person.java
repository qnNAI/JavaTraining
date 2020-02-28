package ex02_alice_bob;

public class Person implements Runnable {
    String name;

    public Person(String name) {
        this.name = name;
    }

    public void run() {
        for (int i = 0; i < 20; ++i) {
            System.out.println("Hello, my name is " + name);
            System.out.println(Thread.currentThread().toString());
        }


    }
}
