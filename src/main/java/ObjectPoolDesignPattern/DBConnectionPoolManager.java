package ObjectPoolDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class DBConnectionPoolManager {
    private List<DBConnection> freeList = new ArrayList<>();
    private List<DBConnection> inUseList = new ArrayList<>();
    private static final int INITIAL_POOL_SIZE = 3;
    private static final int MAX_POOL_SIZE = 6;
    private static DBConnectionPoolManager dbConnectionPoolManager = null;

    private DBConnectionPoolManager() {
        for(int i=0; i<INITIAL_POOL_SIZE; i++) {
            DBConnection dbConnection = new DBConnection();
            freeList.add(dbConnection);
        }
    }

    public static DBConnectionPoolManager getInstance() {
        if(dbConnectionPoolManager == null) {
            synchronized (DBConnectionPoolManager.class) {
                if(dbConnectionPoolManager == null) {
                    dbConnectionPoolManager = new DBConnectionPoolManager();
                }
            }
        }
        return dbConnectionPoolManager;
    }

    public synchronized DBConnection getDBConnection() {
        if(freeList.isEmpty() && inUseList.size() < MAX_POOL_SIZE) {
            DBConnection dbConnection = new DBConnection();
            System.out.println("Creating a new DB Connection as we have space");
            freeList.add(dbConnection);
        }
        else if(freeList.isEmpty() && inUseList.size() >= MAX_POOL_SIZE) {
            System.out.println("Cannot create a new DB Connection as we have reached max space and all are in use");
            return null;
        }
        DBConnection dbConnection = freeList.remove(freeList.size() - 1);
        inUseList.add(dbConnection);
        return dbConnection;
    }

    public synchronized void releaseDBConnection(DBConnection dbConnection) {
        inUseList.remove(dbConnection);
        freeList.add(dbConnection);
    }

}
