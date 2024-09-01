package LeetCode.SHINE240901;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName T2copy
 * @Author Demin Peng
 * @Date 2024/9/1 21:16
 * @Description 针对T2的代码优化版本
 */

public class T2copy {
    public static void main(String[] args) {
        int[][] intervals = { {1, 4},
                {5, 7},
                {2, 3},
                {6, 8},
                {9, 10}};
        int[][] res = mergeIntervals(intervals);
        for(int[] i : res){
            System.out.println(Arrays.toString(i));
        }
    }

    public static int[][] mergeIntervals(int[][] intervals){
        List<int[]> mergeList = new ArrayList<>();
        //1、对区间起始天数进行排序
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        //2、合并区间，一方面减少原先区间数量，另一方面重组区间
        for(int i =0;i< intervals.length;){
            //int newLeftDay = intervals[i][0];
            int newLastDay = intervals[i][1];
            int j =i+1;
            while(j<intervals.length && intervals[j][0] <= newLastDay){
                newLastDay = Math.max(newLastDay,intervals[j][1]);
                j++;
            }
            mergeList.add(new int[]{intervals[i][0],newLastDay});
            i=j;
        }

        return mergeList.toArray(new int[mergeList.size()][]);

    }
}
