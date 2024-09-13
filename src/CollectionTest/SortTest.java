package CollectionTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author：彭德民
 * @ClassName：SortTest
 * @Date：2024/7/31 16:38
 * @Description：集合排序的几种实现方式
 */

public class SortTest {
    public static void main(String[] args) {
        // 0.数据准备
        List<String> arrayList = new ArrayList<>();
        arrayList.add("z");
        arrayList.add("a");
        arrayList.add("c");
        arrayList.add("b");
        System.out.println("插入顺序："+arrayList);


        // 1.自然排序
        Collections.sort(arrayList);
        System.out.println("自然排序："+arrayList);

        // 2.比较器定制排序
        Collections.sort(arrayList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        System.out.println("定制排序方式1："+arrayList);
        arrayList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println("定制排序方式2："+arrayList);

        arrayList.sort(Comparator.naturalOrder());

        // 3.反转排序
        Collections.reverse(arrayList);
        System.out.println("反转排序："+arrayList);

        // 4.随机排序
        Collections.shuffle(arrayList);
        System.out.println("随机排序："+arrayList);


    }
}
