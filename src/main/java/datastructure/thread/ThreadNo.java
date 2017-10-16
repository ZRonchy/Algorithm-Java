package datastructure.thread;

class Out implements Runnable {
    public synchronized void run() {
        for (int x = 0; x < 10; x++) {
            System.out.println(Thread.currentThread().getName());
        }
    }
}

public class ThreadNo {
    public static void main(String[] args) {
        Out o = new Out();

        Thread t1 = new Thread(o, "foo");
        Thread t2 = new Thread(o, "bar");

        t1.start();
        t2.start();
    }
}

