package LLD.SingletonDesignPattern;

public class DBConnection {

    private static volatile DBConnection connection;
    private DBConnection(String name) {
        System.out.println("DB connection is established by: " + name);
    }

     static synchronized DBConnection getDBConnection(String name) {
        if(connection == null) {
            synchronized (DBConnection.class) {
                if (connection == null) {
                    connection = new DBConnection(name);
                }
            }
        }
        return connection;
    }
}
