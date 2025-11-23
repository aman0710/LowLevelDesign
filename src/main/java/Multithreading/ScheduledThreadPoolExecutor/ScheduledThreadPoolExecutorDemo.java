package Multithreading.ScheduledThreadPoolExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExecutorDemo {
    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
        service.scheduleAtFixedRate(new Task(), 1000, 2000, TimeUnit.MILLISECONDS);
        try {
            if(!service.awaitTermination(10000, TimeUnit.MILLISECONDS)) {
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            service.shutdownNow();
        }
    }
}

class Task implements Runnable {

    @Override
    public void run() {
        System.out.println("Probing end point for updates...");
    }
}
