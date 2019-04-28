package unclassfied.juc;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
// Use BlockingQueue to implement
class Producer implements Runnable {
    private final BlockingQueue sharedQueue;

    public Producer(BlockingQueue sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println("Producer:" + i);
                sharedQueue.put(i);
            } catch (InterruptedException ex) {
                System.out.println("exception:" + ex);
            }
        }
    }
}

class Consumer implements Runnable {
    private final BlockingQueue sharedQueue;

    public Consumer(BlockingQueue sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    public void run() {
        while (true) {
            try {
                System.out.println("Consumed:" + sharedQueue.take());
            } catch (InterruptedException ex) {
                System.out.println("Exception:" + ex);
            }
        }
    }
}

public class ProducerConsumerBlockingQueue {
    public static void main(String[] args) {
        //阻塞队列
        BlockingQueue sharedQueue = new LinkedBlockingDeque();

        //创建生产者和消费者，共享队列
        Thread prodThread = new Thread(new Producer(sharedQueue));
        Thread consThread = new Thread(new Consumer(sharedQueue));

        //开启生产者和消费者进程
        prodThread.start();
        consThread.start();
    }
}

