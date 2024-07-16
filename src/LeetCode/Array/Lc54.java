package LeetCode.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Lc54
 * @Description 力扣54题螺旋矩阵, 使用按层模拟法
 * @Author 彭德民
 * @Date 2024/4/30 20:42
 */

public class Lc54 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> order = spiralOrder(matrix);
        order.forEach(i -> System.out.println(i));

    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> resList = new ArrayList<Integer>();
        if (matrix.length == 0 || matrix == null || matrix[0].length == 0) {
            return resList;
        }
        //先获取行、列信息
        int rows = matrix.length, cols = matrix[0].length;
        //找到矩阵四个角，即四个边界
        int left = 0, right = cols - 1, top = 0, bottom = rows - 1;
        //判断每次循环开始前的边界是否符合要求，因为上一次循环结束后，边界会发生变化
        while (left <= right && top <= bottom) {
            //一次（层）循环包括右下左上四个步骤，但不是每个步骤都一定执行到，要看边界情况
            //1、尝试往从左往右走
            for (int colIndex = left; colIndex <= right; colIndex++) {
                resList.add(matrix[top][colIndex]);
            }
            //2、碰到边界后从上往下走
            for (int rowIndex = top + 1; rowIndex <= bottom; rowIndex++) {
                resList.add(matrix[rowIndex][right]);
            }
            //不是每个步骤都一定执行到，要再判断下边界情况
            //如果此时left=right,说明只有一列，那前面第二步从上往下走时就已经访问过了
            //如果此时top=bottom,说明只有一行，那前面第一步从左往右走时就已经访问过了
            if (left < right && top < bottom) {
                //3、碰到边界后从有往左走
                for (int colIndex = right - 1; colIndex >= left; colIndex--) {
                    resList.add(matrix[bottom][colIndex]);
                }
                //4、碰到边界后从下往上走
                for (int rowIndex = bottom - 1; rowIndex > top; rowIndex--) {
                    resList.add(matrix[rowIndex][left]);
                }
            }
            //一层循环之后，矩阵四个边角都要往里收缩一圈
            left++;
            right--;
            top++;
            bottom--;
        }
        int[] a1 = resList.stream().mapToInt(Integer::intValue).toArray();
        int[] a2;
        return resList;
    }
}
