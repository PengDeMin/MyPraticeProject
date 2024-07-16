package Test;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @ClassName typeTets
 * @Description TODO
 * @Author 彭德民
 * @Date 2024/5/14 16:55
 */

public class typeTets {
    public static void main(String[] args) {
        int a = 10;//基本类型
        Integer aInt = Integer.valueOf(a);//装箱
        aInt += 20;
        System.out.println(Integer.TYPE.getName());
        int b = aInt.intValue();//拆箱

        BigInteger aBig = BigInteger.valueOf(10);//超过long类型
        aBig = aBig.add(BigInteger.valueOf(30));
        int c = aBig.intValue();//拆箱
        System.out.println(aBig);

        BigDecimal aDecimal = BigDecimal.valueOf(a);
        aDecimal = aDecimal.add(new BigDecimal(20));
        System.out.println(aDecimal);

        final int dd = 10;
    }
}
