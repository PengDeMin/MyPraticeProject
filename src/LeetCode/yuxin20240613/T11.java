package LeetCode.yuxin20240613;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @ClassName T11
 * @Description TODO
 * @Author 彭德民
 * @Date 2024/6/13 10:44
 */

public class T11 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n =  in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();

        Map<Integer,Integer> freRec= new HashMap<>();
        //输入n个整数
        for(int i = 0; i < n; i++) {
            int number = in.nextInt();
            freRec.put(number,freRec.getOrDefault(number,0)+1);
        }
        //找到出现b次的数字并输出
        for (Map.Entry<Integer,Integer> entry: freRec.entrySet()){
            if (entry.getValue().equals(b)){
                System.out.println(entry.getKey());
                break;
            }
        }
    }
}
