package LeetCode;

import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @ClassName jiujiangTest
 * @Description TODO
 * @Author 彭德民
 * @Date 2024/6/18 19:49
 */

public class jiujiangTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String str = sc.next();
        if (str.length() != n){
            return;
        }
        int strLength = str.length();
        int result = 0 ;
        Set<Character> tempSet = new HashSet<>();
        //一共可以删除1~(strLength-k)长度的子串
        for(int i = 1; i <= strLength-k; i++){
            for(int j = 0; j+i<= strLength;j++){
                //String tempStr = str.replaceAll(str.substring(j,j+i), "");
                String tempStr = str.substring(0,j)+str.substring(j+i,strLength);
                System.out.println(tempStr);
                tempSet.clear();
                for (char c : tempStr.toCharArray()) {
                    tempSet.add(c);
                }
                if(tempSet.size()>=k){
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}
