package LeetCode.Media0913;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName T2
 * @Author Demin Peng
 * @Date 2024/9/13 20:39
 * @Description TODO
 */

public class T2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int i = 6;
        while(i<9){
            System.out.print(array[i++]+" ");
        }
        int j = 0;
        while(j<5){
            System.out.print(array[j++]+" ");
        }
        System.out.print(array[5]);

    }
}
