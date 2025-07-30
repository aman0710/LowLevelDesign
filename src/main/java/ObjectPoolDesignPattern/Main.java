package ObjectPoolDesignPattern;

public class Main {
    public static void main(String[] args) {
        DBConnectionPoolManager dbConnectionPoolManager = DBConnectionPoolManager.getInstance();
        DBConnection connection1 = dbConnectionPoolManager.getDBConnection();
        DBConnection connection2 = dbConnectionPoolManager.getDBConnection();
        DBConnection connection3 = dbConnectionPoolManager.getDBConnection();
        DBConnection connection4 = dbConnectionPoolManager.getDBConnection();
        DBConnection connection5 = dbConnectionPoolManager.getDBConnection();
        DBConnection connection6 = dbConnectionPoolManager.getDBConnection();
        DBConnection connection7 = dbConnectionPoolManager.getDBConnection();
        System.out.println("connection7 : " + connection7);
        dbConnectionPoolManager.releaseDBConnection(connection6);
    }
}
