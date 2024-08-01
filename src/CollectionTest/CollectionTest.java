package CollectionTest;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author：彭德民
 * @ClassName：CollectionTest
 * @Date：2024/7/31 11:46
 * @Description：TODO
 */

public class CollectionTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        list.add(1);
        set.add(1);

        list.forEach(s-> System.out.println(s));
        set.forEach(s-> System.out.println(s));
        list.get(0);

        Map<Integer,Integer> map = new ConcurrentHashMap<>();
        map.putIfAbsent(1, 1);

        //使用ArrayList时解决线程安全问题的一种举措
        List<Integer> list2 = Collections.synchronizedList(list);


    }
}
