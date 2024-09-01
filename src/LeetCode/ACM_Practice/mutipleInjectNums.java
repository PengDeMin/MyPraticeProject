package LeetCode.ACM_Practice;

import java.util.*;
/**
 * @ClassName mutipleIn
 * @Author Demin Peng
 * @Date 2024/9/1 15:48
 * @Description ACM输入输出模版练习-多行数据，数据均为整数
 */

public class mutipleInjectNums {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /*多行输入，每行两个数，例子：
        1 2
        3 4
        5 6
        ...
         */
//        while(sc.hasNextInt()){
//            int a = sc.nextInt();
//            int b = sc.nextInt();
//            System.out.println(a+b);
//        }

        /*第一行是一个整数N，表示后面会有N行a和b，通过空格隔开，例子：
        2
        2 4
        9 21 -- 第一组测试数据
        2
        3 4
        19 21 -- 第二组测试数据
        ...
         */
//        while(sc.hasNext()){
//            int n = sc.nextInt();
//            while(n-->0){
//                int a = sc.nextInt();
//                int b = sc.nextInt();
//                System.out.println(a+b);
//            }
//        }

        /* 多组数据，每组数据都是两个整数，直到输入0 0结束，例子：
        1 2
        3 4
        0 0 -- 结束
         */
//        while(sc.hasNextInt()){
//            int a = sc.nextInt();
//            int b = sc.nextInt();
//            if(a==0 && b==0){
//                return;
//            }
//            System.out.println(a+b);
//        }

        /*若⼲⾏输⼊，遇到0终⽌，每⾏第⼀个数为N，表示本⾏后⾯有N个数
        4 1 2 3 4
        5 1 2 3 4 5
        0 -- 结束
         */
//        while(sc.hasNextInt()){
//            int n = sc.nextInt();
//            if(n==0){
//                return;
//            }
//            int thisSum = 0;
//            while(n-->0){
//                thisSum+=sc.nextInt();
//            }
//            System.out.println(thisSum);
//        }

        /*
        输入包含若干行，每行输入两个整数a和b，由空格分隔。
        对于每组输入，输出a和b的和，每行输出后接一个空行。
        2 4
        11 19

        输出：
        6

        30
         */
//        while (sc.hasNext()){
//            int a = sc.nextInt();
//            int b = sc.nextInt();
//            System.out.println(a+b);
//            System.out.println();
//        }

        /* 多组n⾏数据，每⾏先输⼊⼀个整数N，接下来N行每行先输入一个整数M，
        然后在同一行内输入M个整数。,每组输出之间输出⼀个空⾏
        3
        4 1 2 3 4
        5 1 2 3 4 5
        3 1 2 3
         */
//        while(sc.hasNextInt()){
//            int rows = sc.nextInt();
//            while(rows-->0){
//                int cols = sc.nextInt();
//                int curSum = 0;
//                while(cols-->0){
//                    curSum += sc.nextInt();
//                }
//                System.out.println(curSum);
//                System.out.println();
//            }
//        }

        /* 多组测试⽤例，第⼀⾏为正整数n, 第⼆⾏为n个正整数，
        n=0时，结束输⼊，每组输出结果的下⾯都输出⼀个空⾏:
        6
        5 2 4 1 7 5
        0 -- 结束
         */
//        while(sc.hasNextInt()){
//            int size = sc.nextInt();
//            if(size == 0) return;
//            ArrayList<Integer> list = new ArrayList<>();
//            while(size-->0){
//                list.add(sc.nextInt());
//            }
//            //遍历数组
//            for(Integer num: list){
//                System.out.println(num);
//            }
//            System.out.println();
//        }

        /* 多行数据，每行都是一个多位数的整数，解析获得其每一位的数字，输出后下面输入一行空格行
        12345678
        12342312
        ....
         */
//        while(sc.hasNextInt()){
//            int num = sc.nextInt();
//            while(num>0){
//                System.out.println(num%10);
//                num/=10;
//            }
//            System.out.println();
//        }


    }
}
