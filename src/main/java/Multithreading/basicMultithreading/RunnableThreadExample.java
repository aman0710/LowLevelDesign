package Multithreading.basicMultithreading;

public class RunnableThreadExample {
    public static void main(String[] args) {
        Thread one = new Thread(new threadOne());
        Thread two = new Thread(new threadTwo());
        Thread three = new Thread(() -> {
            for(int i=0; i<5; i++) {
                System.out.println("ThreadThree : " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        one.start();
        two.start();
        three.start();
    }
}

class threadOne implements Runnable {

    @Override
    public void run() {
        for(int i=0; i<5; i++) {
            System.out.println("ThreadOne : " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class threadTwo implements Runnable {

    @Override
    public void run() {
        for(int i=0; i<5; i++) {
            System.out.println("ThreadTwo : " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}