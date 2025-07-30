package ObjectPoolDesignPattern;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    Connection dbConnection;

    public DBConnection() {
        try {
            dbConnection = DriverManager.getConnection("myURL", "username", "password");
        }
        catch(Exception e) {
            System.out.println("Error occurred : " + e.getMessage());
            throw new RuntimeException();
        }
    }
}
