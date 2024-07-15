package LeetCode.xieCheng20240506;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName T2
 * @Description TODO
 * @Author 彭德民
 * @Date 2024/5/6 19:44
 */

public class T2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //输入正整数x
        BigInteger x = scanner.nextBigInteger();
        //输入正整数k,p
        BigInteger k = scanner.nextBigInteger();
        BigInteger p = scanner.nextBigInteger();

        int[] nums1 = new int[1001];
        int index = 0;
        //将每个数分开放入数组中
        while(x.longValue()>0){
            nums1[index++] = (int) (x.longValue()%10);
            x=new BigInteger(String.valueOf(x.longValue() / 10));
        }
        int[] nums2 = new int[index];
        for(int i=0; index>0;i++){
            nums2[i] = nums1[--index];
        }
        //遍历数组,更新数字
        BigInteger bigestNum = BigInteger.valueOf(0);
        for(int i=0;(i+k.intValue()-1)<nums2.length;i++){
            BigInteger sum = BigInteger.valueOf(0);
            //计算本次k数字大小
            for(int j=i;j<i+k.intValue();j++){
                sum = new BigInteger(String.valueOf(nums2[j] + sum.intValue()*10));
            }
            bigestNum = new BigInteger(String.valueOf( Math.max(bigestNum.longValue(),sum.longValue())));
        }
        //计算模的值
        System.out.println(bigestNum.longValue() % p.longValue());
    }

}
