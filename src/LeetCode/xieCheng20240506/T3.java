package LeetCode.xieCheng20240506;

import java.math.BigInteger;

/**
 * @ClassName T3
 * @Description TODO
 * @Author 彭德民
 * @Date 2024/5/6 20:54
 */

public class T3 {
    public static void main(String[] args) {
        int a = 10;//基本类型
        Integer aInt = Integer.valueOf(a);//装箱
        BigInteger aBig = BigInteger.valueOf(10);//超过long类型
        aBig.add(BigInteger.valueOf(30));
        System.out.println(aBig);
    }
}
