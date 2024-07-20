package LeetCode._1_Array.SpiralMatrix;

import java.util.Scanner;

/**
 * @Author：彭德民
 * @ClassName：Four_1_Lc59_mid
 * @Date：2024/7/17 15:50
 * @Description：题螺旋矩阵II
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 */

public class Four_1_Lc59_mid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int  intNum = sc.nextInt();
        int[][] res = generateMatrix2(intNum);
        for (int[] re : res) {
            for (int i : re) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    //思想1：分层模拟，但没有考虑边角情况
    public static int[][] generateMatrix1(int n) {
        int[][] res = new int[n][n];
        int startIndex = 0;
        int startNum = 1;
        //n-=2是因为下一次循环的插入步长要减2
        //startIndex++是因为下一次循环的开始位置从res[startIndex][startIndex]变成res[startIndex+1][startIndex+1]
        for (; n > 0; n -= 2, startIndex++) {
            //一次右下左上的插入循环
            startNum = insertLoop(res, startIndex, n, startNum);
        }
        return res;
    }

    //每一次的插入循环（右->下->左->上），每次循环都从res[startIndex][startIndex]的位置开始插入
    public static int insertLoop(int[][] res, int startIndex, int n, int startNum) {
        //1、先向右走n步，插n次，因为n步中一个位置都没有插入过
        int index;
        int row = startIndex, col = startIndex - 1;
        for (index = 0; index < n; index++) {
            res[row][++col] = startNum++;
        }
        //2、然后向下走n-1步，插n-1次，因为n步中最上边的一个位置之前已经插入过了
        for (index = 1; index < n; index++) {
            res[++row][col] = startNum++;
        }
        //3、然后向左走n-1步，插n-1次，因为n步中最右边的一个位置之前已经插入过了
        for (index = 1; index < n; index++) {
            res[row][--col] = startNum++;
        }
        //4、然后往上走n-2步，插n-2次，因为n步中最上边和最下边的两个位置之前已经插入过了
        for (index = 2; index < n; index++) {
            res[--row][col] = startNum++;
        }
        return startNum;
    }

    //思想2(这种思想更好)：按层模拟，考虑边角情况，每一层完成后边角收缩
    public static int[][] generateMatrix2(int n) {
        int[][] res = new int[n][n];
        int insertNum = 1;
        //确定四个边角
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        //判断每次循环开始前的边界是否符合要求，因为上一次循环结束后，边界会发生变化
        while (left <= right && top <= bottom) {
            //一次（层）循环包括右下左上四个步骤，但不是每个步骤都一定执行到，要看边界情况
            //1、从左往右走
            for (int colIndex = left; colIndex <= right; colIndex++) {
                res[top][colIndex] = insertNum++;
            }
            //2、从上往下走
            for (int rowIndex = top + 1; rowIndex <= bottom; rowIndex++) {
                res[rowIndex][right] = insertNum++;
            }
            //不是每个步骤都一定执行到，要再判断下边界情况
            //如果此时left=right,说明只有一列，那前面第二步从上往下走时就已经访问过了
            //如果此时top=bottom,说明只有一行，那前面第一步从左往右走时就已经访问过了
            if (left < right && top < bottom) {
                //3、碰到边界后从有往左走
                for (int colIndex = right - 1; colIndex >= left; colIndex--) {
                    res[bottom][colIndex] = insertNum++;
                }
                //4、碰到边界后从下往上走
                for (int rowIndex = bottom - 1; rowIndex > top; rowIndex--) {
                    res[rowIndex][left] = insertNum++;
                }
            }
            //一层循环之后，矩阵四个边角都要往里收缩一圈
            left++;
            right--;
            top++;
            bottom--;
        }
        return res;
    }
}
