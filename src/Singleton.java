import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: lichaoyang
 * @Date: 2020-09-10 11:29
 */
public class Singleton {

    private Singleton(){
        ConcurrentHashMap<String,String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("name","lll");
    }

    private static  volatile  Singleton instance;

    public static  Singleton getInstance(){
        if (instance == null){
            synchronized (Singleton.class){
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }



}
