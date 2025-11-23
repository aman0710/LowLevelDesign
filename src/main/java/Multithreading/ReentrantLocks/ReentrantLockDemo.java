package Multithreading.ReentrantLocks;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    private final ReentrantLock lock = new ReentrantLock();
    private int sharedData = 0;
    private void methodA() {
        lock.lock();
        try {
            sharedData++;
            System.out.println("Locks present : " + lock.getHoldCount());
            System.out.println("Method A: sharedData = " + sharedData);
            methodB();
        } finally {
            lock.unlock();
        }
    }

    private void methodB() {
        lock.lock();
        try {
            sharedData--;
            System.out.println("Locks present : " + lock.getHoldCount());
            System.out.println("Method B: sharedData = " + sharedData);
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLockDemo example = new ReentrantLockDemo();
        for(int i=0; i<5; i++) {
            new Thread(() -> {
                example.methodA();
            }).start();
        }
    }
}
