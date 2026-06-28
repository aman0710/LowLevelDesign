package LLD.SingletonDesignPattern;

public class Main {
    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            DBConnection.getDBConnection("Connection 1");
        });

        Thread t2 = new Thread(() -> {
            DBConnection.getDBConnection("Connection 2");
        });

        Thread t3 = new Thread(() -> {
            DBConnection.getDBConnection("Connection 3");
        });


        t1.start();
        t2.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        t3.start();
    }
}
