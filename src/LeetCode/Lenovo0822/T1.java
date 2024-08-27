package LeetCode.Lenovo0822;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName T1
 * @Author Demin Peng
 * @Date 2024/8/22 20:39
 * @Description TODO
 */

public class T1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int monsterNum = Integer.parseInt(scanner.nextLine());
        int[] monsterCoord = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] startAndEndCoord = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        if(monsterCoord == null || monsterCoord.length!= 2*monsterNum
                || startAndEndCoord == null || startAndEndCoord.length != 4){
            System.out.println(0);
            return;
        }

        int destroyNum = 0;
        //1、取出起点和终点的坐标
        int startX = startAndEndCoord[0];
        int startY = startAndEndCoord[1];
        int endX = startAndEndCoord[2];
        int endY = startAndEndCoord[3];

        //2、根据起点和终点坐标求解对应一元一次方程y=ax+b的a和b参数
        BigDecimal a = new BigDecimal(endY - startY).divide(new BigDecimal(endX - startX));
        //double a = (endY - startY)/(endX - startX);
        BigDecimal b = new BigDecimal(startY).subtract(a.multiply(new BigDecimal(startX)));
//        double b1 = startY - a * startX;
//        double b2 = endY - a * endX;

        //3、遍历各个怪物的坐标，看怪物是否处于y=ax+b的曲线上
        for (int i = 0; i < monsterCoord.length; i+=2) {
            int monsterX = monsterCoord[i];
            BigDecimal calY = a.multiply(new BigDecimal(monsterX)).add(b);
            //int calY = (int) (a * monsterX + b);
            //在曲线上则消灭数量+1
            if(calY.equals(monsterCoord[i+1])){
                destroyNum++;
            }
        }

//        for (int i = 0; i < monsterCoord.length; i+=2) {
//            int monsterX = monsterCoord[i];
//            int monsterY = monsterCoord[i+1];
//            int calY1 = (int) (a * monsterX + b1);
//            int calY2 = (int) (a * monsterX + b2);
//            //在曲线上则消灭数量+1
//            if(monsterY == calY1 || monsterY== calY2){
//                destroyNum++;
//            }
//        }


        System.out.println(destroyNum);
    }
}
