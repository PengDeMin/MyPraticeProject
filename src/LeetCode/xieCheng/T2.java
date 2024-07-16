package LeetCode.xieCheng;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @ClassName T2
 * @Description 携程2024.4.16春招第二题
 * @Author 彭德民
 * @Date 2024/5/6 18:28
 */

public class T2 {
    //存放a数组
    static final long[] a = new long[100010];
    //存放a+b
    static final Map<Long, Long> sumMap = new HashMap<>();
    //存放c数组
    //static final Map<Long,Long> cMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long res = 0;
        //输入数组大小
        long arrayLen = scanner.nextInt();
        //输入数组a
        for (int i = 0; i < arrayLen; i++) {
            a[i] = scanner.nextLong();
        }
        //输入数组b的值，直接想加(注意可能冲出现重复值)，不需要额外空间
        for (int i = 0; i < arrayLen; i++) {
            long numB = scanner.nextLong();
            a[i] += numB;
            //放入a+b,若出现重复值则频数+1
            sumMap.put(a[i], sumMap.getOrDefault(a[i], 0L) + 1);
        }
        //输入数组C
        for (int i = 0; i < arrayLen; i++) {
            long numC = scanner.nextLong();
            if (sumMap.containsKey(numC)) {
                //交集加一；
                res++;
                long newFre = sumMap.get(numC) - 1;
                if (newFre > 0) {
                    sumMap.put(numC, newFre);
                } else {
                    sumMap.remove(numC);
                }
            }

            //cMap.put(numC,cMap.getOrDefault(numC,0L)+1);
        }

        //遍历并求两个Map的交集
//        for(Map.Entry<Long,Long> entry:cMap.entrySet()){
//            //1、当cMap.getOrDefault(entry.getKey(),0L)=0，说明当前这个c没有a+b等于它
//            //2、当cMap.getOrDefault(entry.getKey(),0L)！=0，说明当前这个c有a+b等于
//            //但要取两者交集，比如你5个10我们3个10，那只有3个10两边都能对应上
//            res += Math.min(entry.getKey(),
//                    cMap.getOrDefault(entry.getKey(),0L));
//        }
        System.out.println(res);

    }
}
