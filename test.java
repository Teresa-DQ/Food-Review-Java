import java.util.HashMap;
import java.util.Map;

public class HashMapUnsafeExample {
    public static void main(String[] args) throws InterruptedException {
        Map<Integer, String> map = new HashMap<>();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                map.put(i, "Thread1-" + i);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                map.put(i, "Thread2-" + i);
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Map size: " + map.size()); // 可能 < 1000（数据丢失）
    }
}