package LeetCode;

import java.util.*;

/**
 * @ClassName wangyiT3
 * @Description TODO
 * @Author 彭德民
 * @Date 2024/6/20 20:33
 */

public class wangyiT3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n  = scanner.nextInt();//星系建筑数量



        int[] xCoor = new int[n];
        int[] yCoor = new int[n];
        int[] radius = new int[n];
        //1、输入星系每个坐标的值和影响力
        for (int i = 0; i < n; i++) {
            xCoor[i] = scanner.nextInt();
            yCoor[i] = scanner.nextInt();
            radius[i] = scanner.nextInt();
        }
        int q = scanner.nextInt();//询问次数
        int[] res = new int[q];
        //2、输入询问坐标并判断被影响数量
        for (int i = 0; i < q; i++) {
            int xRequest = scanner.nextInt();
            int yReuqest = scanner.nextInt();
            int influenced = 0;
            for(int j = 0; j < n; j++){
                if(Math.max(Math.abs(xCoor[j]-xRequest),
                        Math.abs(yCoor[j]-yReuqest)) <= radius[j]){
                    influenced++;
                }
            }
            res[i] = influenced;
        }

        //3、输出结果
        for (int i = 0; i < q; i++){
            System.out.println(res[i]);
        }
    }
}



