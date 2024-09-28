package LeetCode._5_StackAndQueue;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;

/**
 * @Author：彭德民
 * @ClassName：_3_Lc1047_removeDuplicates
 * @Date：2024/9/5 10:40
 * @Description：删除字符串中的所有相邻重复项
 */

public class _3_Lc1047_removeDuplicates_easy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s= scanner.next();
        System.out.println(removeDuplicates(s));
    }

    public static String removeDuplicates(String s) {
        //Stack<Character> stack  = new Stack<>();
        //ArrayDeque会比LinkedList在除了删除元素这一点外会快一点
        Deque<Character> deque = new ArrayDeque<>();
        for(int i = 0; i<s.length();i++){
            char c = s.charAt(i);
            if(deque.isEmpty()||deque.peek()!=c){
                deque.push(c);
            }else{
                deque.pop();
            }
        }
        String str = "";
        //使用头插法将栈转为字符串
        while(!deque.isEmpty()){
            str = deque.pop()+str;
        }
        return str;
    }
}
