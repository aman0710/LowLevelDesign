package Multithreading.FutureAndCallable;

import java.util.concurrent.*;

public class FutureAndCallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService service = Executors.newFixedThreadPool(2);
        Future<Integer> result = service.submit(new ReturnValueTask());
        service.shutdown();

        System.out.println(result.get(6, TimeUnit.SECONDS));
        System.out.println("Main thread execution completed!");
    }
}

class ReturnValueTask implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        Thread.sleep(5000);
        return 12;
    }
}