package LeetCode.SHINE240901;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName IntervalMergeR
 * @Author Demin Peng
 * @Date 2024/9/1 20:14
 * @Description 其实就是LC56题
 *某软件在日志中记录了每个用户多端的使用情况，
 * 我们不定期合并近期同一个端的连续多天使用记录的闭区间，
 * 表示为该年第几天到第几天活跃过。请你继续合并输入的多组数据，最终输出互不重叠的活跃区间。
 * 输入限制:输入是一个二维正整数数组，每个元素是两个整数，表示该连续活跃时段的起始天和终止天的闭区间，
 * 输出限制:输出一个合并后的活跃时段团区间数组。
 * 如输入：
 * {1, 4},
*  {5, 7},
*  {2, 3},
*  {6, 8},
*  {9, 10}
 *  输出之后变成
 * [1, 4]
 * [5, 8]
 * [9, 10]
 *
 * 解答的核心思路：
 * 1、对区间起始天数进行排序
 * 2、合并区间，一方面减少原先区间数量，另一方面重组区间
 * （1）以当前还没被合并过的第一个区间intervals[i]为基准区间，可以想象，此次最终合并所得区间的左端一定是基准区间的左端:newLeft=intervals[i][0]
 * （2）因此，重点考虑新区间右端的值，以基准区间的右端为新区间的基准值:newLastDay = intervals[i][1]
 * （3）往后面遍历区间，看后面区间的右端有没有小于新区间的基准值，并不断根据大小更新基准值newLastDay
 * （4）此次小遍历会在后面区间的左端大于新区间的右端newLastDay时停止，把此次小遍历得到的结果区间放入结果集中
 * 3、跳到第二步，继续开始找新的基准区间进行合并，直至合并完所有的区间
 */

public class _Lc56_T2_IntervalMerge_mid {
    public static void main(String[] args) {
        int[][] intervals = { {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}};
        int[][] res = mergeIntervals(intervals);
        for(int[] i : res){
            System.out.println(Arrays.toString(i));
        }
    }

    public static int[][] mergeIntervals(int[][] intervals){
        //制定返回的结果集
        //因为不知道最终结果集中有几个区间，因此用集合而不是数组
        List<int[]> mergeList = new ArrayList<int[]>();

        //1、对区间起始天数进行排序
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);

        //2、合并区间，一方面减少原先区间数量，一方面重组区间
        //一次for循环即可合并出一个新的、无法再合并的区间
        for(int i = 0; i < intervals.length;){
            //对于新区间，左端肯定是第i个区间的左端，因为区间已经经过排序
            //因此只需要考虑新区间的后端
            int newLeftDay = intervals[i][0];
            //以还没被合并过的第i个区间为基准区间向后合并,先记录下基准区间的尾部作为新区间的右端基准值
            int newLastDay = intervals[i][1];
            //尝试将后面的区间与第i个区间合并，开始合并for循环
            int j = i+1;
            while(j < intervals.length){
                //后面的区间的左端小于新区间的当前基准右端，可以合并
                if(intervals[j][0] <= newLastDay){
                    //更新区间尾部
                    newLastDay = Math.max(newLastDay,intervals[j][1]);
                    j++;
                }
                else{
                    //后面的区间的左端大于新区间的基准左端，不能再合并了
                    //不可以合并则跳出
                    break;
                }
            }
            //搞定一次合并，将合并后的区间加入结果集
            mergeList.add(new int[]{newLeftDay,newLastDay});
            //更新i，跳到还没被合并过的区间处，准备开始下一次循环
            i = j ;
        }
        //返回最终的结果集
        //将list转为数组，数组大小就是list大小：mergeList.size()
        //且数组中每个元素也都是一个小数组
        return mergeList.toArray(new int[mergeList.size()][]);
    }
}
