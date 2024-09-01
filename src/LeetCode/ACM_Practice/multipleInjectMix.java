package LeetCode.ACM_Practice;
import java.util.*;
/**
 * @ClassName multipleInjectMix
 * @Author Demin Peng
 * @Date 2024/9/1 17:30
 * @Description 多行输入，数据类型混合
 */

public class multipleInjectMix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /*  多⾏输⼊，每⾏输⼊为⼀个字符和⼀个整数，遇到特殊字符@结束
        A 7
        B 5
        @ --结束
         */
//        while(sc.hasNext()){
//            String line = sc.nextLine();
//            if(line.equals("@")) break;
//            String[] inputs = line.split(" ");
//            char ch = inputs[0].charAt(0);
//            int n = Integer.parseInt(inputs[1]);
//            System.out.println(ch+" " + n);
//        }

        /*
        第⼀⾏是⼀个整数n，表示⼀共有n组测试数据, 之后输⼊n⾏字符串,如：
        2
        abdfg
        asdsd
        3
        dsda
        fefef
        wqw
        ....
         */
//        while(sc.hasNextInt()){
//            int n = sc.nextInt();
//            //在nextInt()之后要接续nextLine()的话必须要加这句接收并
//            //消化掉键盘输入的换行符，否则会导致下一次nextLine()时，接受不到数据
//            sc.nextLine();
//            StringBuffer sb = new StringBuffer();
//            while(n-->0){
//                String line = sc.nextLine().trim();
//                sb.append(line);
//            }
//            System.out.println(sb.toString());
//        }

        sc.close();
    }
}
