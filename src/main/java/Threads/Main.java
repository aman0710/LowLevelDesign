package Threads;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MyThread thread2 = new MyThread();
        MyRunnable myRunnable = new MyRunnable();
        Thread thread1 = new Thread(myRunnable);

//        thread1.setDaemon(true);
//        thread2.setDaemon(true);

        thread1.start();
        thread2.start();

    }
}
