package Multithreading.FixedThreadPoolExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolExecutorDemo {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);
        for(int i=0; i<7; i++) {
            service.execute(new Task(i));
        }
        service.shutdown();
    }
}

class Task implements Runnable {

    private final int taskId;

    Task(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println("Task ID " + taskId + " being executed by thread " + Thread.currentThread().getName());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}