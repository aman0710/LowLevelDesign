package Multithreading.ConcurrentCollections;

import com.sun.tools.jconsole.JConsoleContext;
import com.sun.tools.jconsole.JConsolePlugin;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueDemo {
    static final int QUEUE_CAPACITY = 10;
    static BlockingQueue<Integer> taskQueue = new ArrayBlockingQueue<>(QUEUE_CAPACITY);

    public static void main(String[] args) {

        // producer thread
        Thread producer = new Thread(() -> {
           for(int i=1; i<21; i++) {
               try{
                   taskQueue.put(i);
                   System.out.println("Task produced : " + i);
                   Thread.sleep(100);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
           }
        });

        // consumer one
        Thread consumerOne = new Thread(() -> {
            while(true) {
                try {
                    int task = taskQueue.take();
                    processTask(task, "ConsumerOne");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        // consumer two
        Thread consumerTwo = new Thread(() -> {
            while(true) {
                try {
                    int task = taskQueue.take();
                    processTask(task, "ConsumerTwo");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        producer.start();
        consumerOne.start();
        consumerTwo.start();
    }

    private static void processTask(int task, String consumer) throws InterruptedException {
        System.out.println("Task : " + task + " being consumed by : " + consumer);
        Thread.sleep(1000);
        System.out.println("Task : " + task + " consumed by : " + consumer);
    }
}
