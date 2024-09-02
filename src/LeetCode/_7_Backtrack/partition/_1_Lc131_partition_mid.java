package LeetCode._7_Backtrack.partition;

import java.lang.String;

import java.util.*;

/**
 * @Author：彭德民
 * @ClassName：_1_Lc131_partition_mid
 * @Date：2024/9/2 17:27
 * @Description：给你一个字符串 s，
 * 请你将 s 分割成一些子串，使每个子串都是回文串
 * 返回 s 所有可能的分割方案。
 */

public class _1_Lc131_partition_mid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s=scanner.next();
        System.out.println(partition(s));
    }

    public static List<List<String>> partition(String s) {
        //1、指定递归回溯函数的参数及返回结果
        Deque<String> path = new ArrayDeque<>();
        List<List<String>> res = new ArrayList<>();

        //2、回溯函数
        partitionHelper(s,0,path,res);

        return res;

    }

    public static void partitionHelper(String s, int startIndex, Deque<String> path, List<List<String>> res){
        //2.1 明确本层纵向递归结束的条件，就是当startIndex遍历到串尾部了
        if(startIndex == s.length()){
            //能遍历到尾部，说明已经找到了一种分割方案，加入到结果集中
            //如果中途有那个子串不是回文串，那在当时就返回了，startIndex不可能会走到队尾
            res.add(new ArrayList<>(path));
            return;
        }

        //2.2 确定本层横向递归的逻辑
        for(int i = startIndex; i<s.length(); i++){
            //看当前子串是否是回文串
            if(isPalindrome(s,startIndex,i)){
                //是则将当前子串放入到这一层for循环的结果
                path.addLast(s.substring(startIndex,i+1));
                //在本层开始向下纵向递归
                partitionHelper(s,i+1,path,res);
                //回溯
                path.removeLast();
            }
            else break;
        }

    }

    //判断母串从start到end的位置的子串是否是回文串
    public static boolean isPalindrome(String s, int start, int end){
        if(start > end) return false;
        //双指针遍历
        while(start<end){
            if(s.charAt(start++)!=s.charAt(end--)) return false;
        }
        return true;
    }

}
