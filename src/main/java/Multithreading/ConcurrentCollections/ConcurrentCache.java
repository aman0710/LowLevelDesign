package Multithreading.ConcurrentCollections;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentCache {
    private static final Map<String, String> cache = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        for(int i=0; i<10; i++) {
            final int threadNum = i;

            new Thread(() -> {
                String key = "Key @ " + threadNum;
                for(int j=0; j<3; j++) {
                    String value = null;
                    try {
                        value = getCachedValue(key);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Thread " + Thread.currentThread().getName() + " : key = " + key + " : value = " + value);

                }
            }).start();
        }
    }

    private static String getCachedValue(final String key) throws InterruptedException {
        String value = cache.get(key);
        if(value == null) {
            value = compute(key);
            cache.put(key, value);
        }
        return value;
    }

    private static String compute(final String key) throws InterruptedException {
        System.out.println(key + " is not present in the cache, so going to compute!");
        Thread.sleep(500);
        return "Value for " + key;
    }

}
