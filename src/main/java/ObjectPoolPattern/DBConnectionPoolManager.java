package ObjectPoolPattern;

import java.util.ArrayList;
import java.util.List;

public class DBConnectionPoolManager {
    private static List<DBConnection> freeList = new ArrayList<>();
    private static List<DBConnection> inUseList = new ArrayList<>();
    private static final int INITIAL_POOL_SIZE = 3;
    private static final int MAX_POOL_SIZE = 6;
    private static DBConnectionPoolManager connectionPoolManager = null;

    private DBConnectionPoolManager() {
        for(int i=0; i<INITIAL_POOL_SIZE; i++) {
            freeList.add(new DBConnection());
        }
    }

    public static DBConnectionPoolManager getInstance() {
        if(connectionPoolManager == null) {
            synchronized (DBConnectionPoolManager.class) {
                if(connectionPoolManager == null) {
                    connectionPoolManager = new DBConnectionPoolManager();
                }
            }
        }
        return connectionPoolManager;
    }

    public synchronized DBConnection getDBConnection() {
        if(freeList.isEmpty() && inUseList.size() < MAX_POOL_SIZE) {
            freeList.add(new DBConnection());
        } else if(freeList.isEmpty() && inUseList.size() >= MAX_POOL_SIZE) {
            System.out.println("Max pool connections obtained");
            return null;
        }
        DBConnection dbConnection = freeList.remove(freeList.size() - 1);
        inUseList.add(dbConnection);
        return dbConnection;
    }

    public synchronized void releaseDBConnection(DBConnection dbConnection) {
        if(dbConnection != null) {
            inUseList.remove(dbConnection);
            freeList.add(dbConnection);
        }
    }
}
