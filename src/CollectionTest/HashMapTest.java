package CollectionTest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @ClassName HASH
 * @Description TODO
 * @Author 彭德民
 * @Date 2024/3/20 20:19
 */

public class HashMapTest {
    public static void main(String[] args) {
        // 创建并赋值 HashMap
        Map<Integer, String> map = new HashMap();
        map.put(1, "Java");
        map.put(2, "JDK");
        map.put(3, "Spring Framework");
        map.put(4, "MyBatis framework");
        map.put(5, "Java中文社群");

        //1、Iterator的entrySet
        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> entry = iterator.next();
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        //2、Iterator的keySet
        Iterator<Integer> iterator2 = map.keySet().iterator();
        while (iterator2.hasNext()) {
            Integer key = iterator2.next();
            System.out.println(key + " " + map.get(key));
        }

        //3、ForEach 的entrySet
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        //4、ForEach 的keySet
        for (Integer key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
        }

        //5、Lambda
        map.forEach((key, value) -> {
            System.out.println(key + " " + value);
        });

        //6、Streams API 单线程
        map.entrySet().stream().forEach((entry) -> {
            System.out.println(entry.getKey() + " " + entry.getValue());
        });

        //7、Steams API 多线程 parallelStream
        map.entrySet().parallelStream().forEach((entry) -> {
            System.out.println(entry.getKey() + " " + entry.getValue());
        });

        StringBuffer buffer = new StringBuffer("AAAAAAAA");
        Exception exception = null;
    }
}
