package LeetCode.Media0913;


import java.io.UncheckedIOException;
import java.util.Scanner;

/**
 * @ClassName T3
 * @Author Demin Peng
 * @Date 2024/9/13 21:17
 * @Description TODO
 */

public class T3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int[] array = new int[T];
        int i = 0;
        while(i<T){
            array[i++] = scanner.nextInt();
        }

        for (int i1 = 0; i1 < array.length; i1++) {
            int num = array[i1];
            //1、看这个星期一的总日历的第几天
            int day = (num-1)*7+1;
            //2、看这一天处于第几年
            int yearTemp = day % 233;
            //看这一天在该年的第几天
            int i11 = 1;
            while(i11<=yearTemp-1){
                day = day - (i11+233);
            }
            int temp =1;
            int year =0;
            while(yearTemp>0){
                yearTemp -= temp;
                temp ++;
                year++;
            }
            //3、求year的最小素数，即为当年月数
            int monthCount = 0;
            for (int j = 2; j <= year; j++) {
                if(year%j==0){
                    monthCount = j;
                    break;
                }
            }
            //4、前y-1个月的天数为
            int ysub1Days = (year+233)/monthCount;
            int month = day/ysub1Days+1;
            int day2 = day-(month-1)*ysub1Days;
            System.out.println(year+" "+month+" "+day2);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
