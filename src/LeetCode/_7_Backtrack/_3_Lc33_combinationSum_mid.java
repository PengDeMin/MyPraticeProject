package LeetCode._7_Backtrack;

import java.util.*;

/**
 * @ClassName _3_Lc33_combinationSum_mid
 * @Author Demin Peng
 * @Date 2024/8/31 17:09
 * @Description  组合总和
 */

public class _3_Lc33_combinationSum_mid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] candidates = Arrays.stream(sc.next().split(",")).mapToInt(Integer::parseInt).toArray();
        int target = sc.nextInt();

        List<List<Integer>> res = combinationSum(candidates, target);
        System.out.println(res);

    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        //1、制定递归函数参数和返回值
        Deque<Integer> path = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);//排序是为了方便后面进行剪枝
        //2、制定递归回溯函数
        combinationHelper(candidates,target,0,0,path,res);

        return res;
    }

    public static void combinationHelper(int[] candidates, int target, int startIndex,int curSum,
                                         Deque<Integer> path, List<List<Integer>> res){
        //2.1 明确本层递归结束的条件
        //要么是和刚好等于target，当前结果符合条件，放入结果集合中，并退出本次递归
        if(curSum == target){
            res.add(new ArrayList<>(path));//找到一个符合条件的结果了，
            return;
        }
        //要么是和刚好大于target，当前结果不符合条件，直接退出本次递归
        // 由于下面的for循环中已经进行剪枝，不会循环到curSum > target的情况，因此注释下面的不会被执行到的代码
//        if(curSum > target ) {
//            return;
//        }

        //2.2制定for循环
        //加上剪枝操作，如果当前和curSum加上当前还在考虑的元素已经大于target，那么直接结束本次循环，避免没必要的遍历，再遍历和之后越来越大
        //核心注意点：剪枝之前必须要对元素进行排序！
        for(int i = startIndex; i< candidates.length && curSum + candidates[i] <= target; i++){
            //基于当前元素的循环处理
            int curNum = candidates[i];
            curSum += curNum;
            path.addLast(curNum);
            //下面开始本次递归，还是从candidate[i]开始，是因为题目说了i可以被无限制重复选取，
            // 就算结果里全是它，如果和符合要求了，也选
            combinationHelper(candidates,target,i,curSum,path,res);
    
            //开始回溯，移除本次循环添加进的元素
            path.removeLast();
            curSum -= curNum;
        }
    }
}
