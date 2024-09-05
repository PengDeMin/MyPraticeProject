package LeetCode._5_StackAndQueue;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * @Author：彭德民
 * @ClassName：hot_2_Lc20_isValid_easy
 * @Date：2024/9/5 9:44
 * @Description：有效的括号
 */

public class hot_2_Lc20_isValid_easy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s= scanner.next();
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s){
        if(s.length()%2 != 0) return false;
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c=='(' || c=='[' || c=='{'){
                stack.push(c);
            }else{
                if(stack.isEmpty()) return false;
                char out = stack.pop();
                if((c == ')' && out != '(')
                        || (c == '}' && out != '{')
                        || (c == ']' && out != '[')){
                    return false;
                }
            }
        }
        //防止出现“((){}[]”这种情况,最后栈里还剩一个（
        return stack.isEmpty();
    }
}
