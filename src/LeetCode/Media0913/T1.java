package LeetCode.Media0913;

import java.util.*;

/**
 * @ClassName T3
 * @Author Demin Peng
 * @Date 2024/9/13 20:51
 * @Description TODO
 */

public class T1 {

    static int countResult = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        Arrays.sort(array);
        countCombine(array);
        System.out.println(countResult*6);
    }

    private static void countCombine(int[] array) {
        //1、制定递归函数的输入参数和返回值
        Deque<Integer> path = new ArrayDeque<>();

        //2、制定回溯递归函数
        combineHelper(array, 0, path);

    }

    private static void combineHelper(int[] array, int startIndex, Deque<Integer> path) {
        //2.1、明确纵向单层递归的终止条件
        if(path.size()==3){
            countResult++;
//            System.out.println(path);
            return;
        }

        //2.2指定横向for循环，横向宽度是集合的个数
        for(int i=startIndex; i<array.length; i++) {
            path.addLast(array[i]);
            combineHelper(array,i+1,path);
            path.removeLast();
        }
    }
}
