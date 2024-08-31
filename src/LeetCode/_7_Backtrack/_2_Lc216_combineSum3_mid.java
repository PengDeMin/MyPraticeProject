package LeetCode._7_Backtrack;
import java.util.*;
/**
 * @ClassName _2_Lc216_combineSum3_mid
 * @Author Demin Peng
 * @Date 2024/8/31 16:12
 * @Description 组合总和3,在1~9里面选出k个数，使得这k个数的和为n
 */

public class _2_Lc216_combineSum3_mid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        List<List<Integer>> res = combinationSum3(k, n);
        System.out.println(res);
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        //1、制定递归函数参数和返回值
        Deque<Integer> path = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();

        //2、制定回溯递归函数
        combineHelper(k, n, 1, 0, path, res);

        return res;
    }


    public static void combineHelper(int k1, int n1, int startNum, int curSum,
                                     Deque<Integer> path, List<List<Integer>> res) {
        //2.1 明确本层纵向递归的终止条件
        if(path.size() == k1 && curSum == n1){
            //个数满足，说明找到一个符合条件的结果了，放入结果集合中
            res.add(new ArrayList<>(path));
            return ;
        }

        //2.2 制定横向for循环,横向宽度就是集合的个数
        //要进行剪枝操作，当当前和curSum大于等于n，那么直接结束本层循环,避免没必要的遍历，再遍历和之后越来越大
        for(int i = startNum; i<=9 && curSum < n1; i++){
            //本次横向for循环以当前元素i为基础进行回溯
            //因此先把i放进去(先挑选i元素)，并且更新当前的和
            path.addLast(i);
            curSum += i;
            //递归
            combineHelper(k1, n1, i+1, curSum, path, res);
            //回溯,即把包含的i元素移除，去看看下下家
            //组合的思想就是不能在一棵树上吊死，全都要考察
            path.removeLast();
            curSum -= i;
        }
    }
}
