package LeetCode._7_Backtrack.Combine;

import java.util.*;

/**
 * @ClassName _1_Lc77_combine_mid
 * @Author Demin Peng
 * @Date 2024/8/31 14:10
 * @Description 组合(中等)
 */

public class _1_Lc77_combine_mid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        List<List<Integer>> res = combine(n, k);
        System.out.println(res);
    }

    private static List<List<Integer>> combine(int n, int k) {
        //1、制定递归函数参数和返回值
        Deque<Integer> path = new ArrayDeque<>();//一个满足条件的结果
        List<List<Integer>> result = new ArrayList();//所有满足条件的结果的集合

        //2、制定回溯递归函数，第一次进去从元素1也就最开头的元素开始
        combineHelper(n,k,1,path,result);

        return result;
    }

    //递归函数
    private static void combineHelper(int n1, int k1, int startNum,
                                      Deque<Integer> path, List<List<Integer>> result) {

        //2.1 明确纵向单层递归的结束条件
        if(path.size() == k1){
            //个数满足，说明找到一个符合条件的结果了，放入结果集合中
            result.add(new ArrayList<>(path));
            //退出本层递归
            return;
        }

        //2.2 制定横向for循环,横向宽度就是集合的个数
//        for(int i = startNum; i<=n1; i++){
//            //本次横向for循环以当前元素i为基础进行回溯
//            //因此先把i放进去(先挑选i元素)
//            path.addLast(i);
//            //3、然后开始以i为基准的本层纵向递归（再往后面挑选元素），后面元素就是i+1吗
//            combineHelper(n1,k1,i+1,path,result);
//            //本次回溯结束，要把i取出来，不然下次回溯i还在里面就会造成结果出现重复元素
//            path.removeLast();
//        }

        //2.3 制定横向for循环,并剪枝
        //path.size()：已被集合选中的元素个数；k1-path.size()：还需要放入的元素个数
        //注意这里的元素是从1开始，原本集合就是1,2,3,4,5....
        for(int i = startNum; i<= n1-(k1-path.size())+1; i++){
            //本次横向for循环以当前元素i为基础进行回溯
            //因此先把i放进去(先挑选i元素)
            path.addLast(i);
            //3、然后开始以i为基准的本层纵向递归（再往后面挑选元素），后面元素就是i+1吗
            combineHelper(n1,k1,i+1,path,result);
            //本次回溯结束，要把i取出来，不然下次回溯i还在里面就会造成结果出现重复元素
            path.removeLast();
        }

    }
}
