package Multithreading.basicMultithreading;

public class ExtendsThreadExample {
    public static void main(String[] args) {
        Thread thread1 = new Thread1();
        Thread thread2 = new Thread2();
        thread1.start();
        thread2.start();
    }
}

class Thread1 extends Thread {
    @Override
    public void run() {
        for(int i=0; i<5; i++) {
            System.out.println("Thread1 : " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Thread2 extends Thread {
    @Override
    public void run() {
        for(int i=0; i<5; i++) {
            System.out.println("Thread2 : " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
