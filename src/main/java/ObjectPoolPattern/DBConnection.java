package ObjectPoolPattern;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    Connection pgConnection;
    DBConnection() {
        try {
            pgConnection = DriverManager.getConnection("hostname", "userName", "password");
        } catch(Exception e) {
            System.out.println("Error occurred : " + e.getMessage());
        }
    }
}
