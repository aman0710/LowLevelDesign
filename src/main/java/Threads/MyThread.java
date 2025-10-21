package Threads;

public class MyThread extends Thread{

    public void run() {
        for(int i=9; i>=0; i--) {
            System.out.println("Thread #2 : " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
        }
        System.out.println("Thread #2 completed processing");
    }
}
