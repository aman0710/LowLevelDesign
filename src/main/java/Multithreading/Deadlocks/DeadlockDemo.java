package Multithreading.Deadlocks;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockDemo {
    private final Lock lockA = new ReentrantLock(true);
    private final Lock lockB = new ReentrantLock(true);

    private void workerOne() {
        lockA.lock();
        System.out.println(Thread.currentThread().getName() + " acquired lockA");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        lockB.lock();
        System.out.println(Thread.currentThread().getName() + " acquired lockB");
        lockA.unlock();
        lockB.unlock();
    }

    private void workerTwo() {
        lockB.lock();
        System.out.println(Thread.currentThread().getName() + " acquired lockB");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        lockA.lock();
        System.out.println(Thread.currentThread().getName() + " acquired lockA");
        lockA.unlock();
        lockB.unlock();
    }

    public static void main(String[] args) {
        DeadlockDemo deadlockDemo = new DeadlockDemo();
        new Thread(deadlockDemo::workerOne, "ThreadOne").start();
        new Thread(deadlockDemo::workerTwo, "ThreadTwo").start();

        new Thread(() -> {
            ThreadMXBean mxBean = ManagementFactory.getThreadMXBean();
            while(true) {
                long[] threadIds = mxBean.findDeadlockedThreads();
                if(threadIds != null) {
                    System.out.println("Deadlock detected!");
                    ThreadInfo[] threadInfo = mxBean.getThreadInfo(threadIds);
                    for(long threadId: threadIds) {
                        System.out.println("Thread with ID : " + threadId + " is in deadlock");
                    }
                    break;
                }
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }
}
