package LeetCode;

import javax.xml.stream.events.Characters;
import java.util.*;

/**
 * @ClassName LinkedTest
 * @Description TODO
 * @Author 彭德民
 * @Date 2024/5/6 17:09
 */

public class ScannerTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        String str = scanner.next();
//        char[] ints = str.toCharArray();
//        System.out.println(ints[1]);
//
//        double v = scanner.nextDouble();
//        System.out.println(v);
        //scanner输入字符型数组并将字符型数组转成整形数组的两种方法
        String str1 = scanner.nextLine();
        String[] str11 = str1.split(",");
        int[] ints1 = Arrays.stream(str11).mapToInt(Integer::parseInt).toArray();
        System.out.println(Integer.parseInt(str11[1]));
//
//
//        String str2 = scanner.nextLine().toString();
//        String[] str12 = str2.split(" ");
//        int[] ints2 = Arrays.asList(str12).stream().mapToInt(Integer::parseInt).toArray();

//        int n = scanner.nextInt();
//        int m = scanner.nextInt();
//        int[][] arr2 = new int[n][m];
//        System.out.println(m+"Test02 输入二维数组数据："+n);

    }
}
