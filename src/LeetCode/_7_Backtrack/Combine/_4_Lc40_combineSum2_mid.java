package LeetCode._7_Backtrack.Combine;

import java.util.*;

/**
 * @Author：彭德民
 * @ClassName：_4_Lc40_combineSum2_mid
 * @Date：2024/9/2 14:31
 * @Description：组合总和2
 * 给定一个候选人编号的集合 candidates和一个目标数 target ，
 * 找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用 一次 。注意：解集不能包含重复的组合。
 */

public class _4_Lc40_combineSum2_mid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] candidates = Arrays.stream(sc.next().split(",")).mapToInt(Integer::parseInt).toArray();
        int target = sc.nextInt();

        List<List<Integer>> res = combinationSum2(candidates, target);
        System.out.println(res);
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //1、制定递归函数参数和返回值
        Deque<Integer> path = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();

        //使用Set是为了防止找到的结果中出现重复元素的组合，如{1,1,2,2,5}，和为5
        //则下面结果会出现多个{1,2,2}和{5}
        //但光使用set只能保证结果不重复，但无法减少重复判断的次数，即无法减少时间
        //因为如果有1万个重复结果，set要重复判断1万次，我们要优化的是减少判断重复的次数
//        Set<List<Integer>> res = new HashSet<>();

        //先进行排序，方便后面剪枝
        Arrays.sort(candidates);

        //2、递归回溯函数
        combinationHelper(candidates,target,0,0,path,res);

        //ArrayList中的构造方法ArrayList(Collection<? extends E> c)
        //可以将多种集合类型的集合转换为ArrayList
        //return new ArrayList<>(res);

        return res;
    }

    public static void combinationHelper(int[] candidates, int target, int startIndex,int curSum,
                                         Deque<Integer> path, List<List<Integer>> res){
        //2.1 明确本层纵向递归结束的条件
        if(curSum == target){
            //但是用
            res.add(new ArrayList<>(path));
            return;
        }

        //3、开始横向for循环，不断遍历集合中的数字
        //剪枝操作，当当前和curSum大于等于n，那么直接结束本层循环,避免没必要的遍历，再遍历和之后越来越大
        for(int i = startIndex;i<candidates.length && curSum+candidates[i] <= target;){
            int curNum = candidates[i];
            path.addLast(curNum);
            curSum += curNum;

            combinationHelper(candidates,target,i+1,curSum,path,res);

            path.removeLast();
            curSum -= curNum;

            //为了避免下一次循环的元素从与本次循环的元素相同，从而浪费时间
            //所以直接跳到与前元素不相同的元素,看看{1,1,2,2,5,5}就知道了
            //先加一次，后面看情况再加
            i++;
            while(i<candidates.length && candidates[i] == candidates[i-1]){
                i++;
            }

        }

    }

}
