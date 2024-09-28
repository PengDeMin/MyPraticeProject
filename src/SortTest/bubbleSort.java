package SortTest;

/**
 * @ClassName bubbleSort
 * @Author Demin Peng
 * @Date 2024/9/27 11:04
 * @Description 交换类-冒泡排序
 * 时间复杂度最坏和平均都是 O(n^2) 最佳是O(n)，空间复杂度 O(1)
 */

public class bubbleSort {

    public static void main(String[] args) {
        int[] arr = {3, 5, 1, 6, 2, 7};
        bubbleSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }

    }

    //把大的冒泡到后面
    private static void bubbleSort(int[] arr) {
        for(int i=1;i< arr.length;i++){
            boolean flag = false;
            for(int j = 0;j< arr.length-i;j++){
                if (arr[j] > arr[j+1]) {
                    arr[j] ^= arr[j+1];
                    arr[j+1] ^= arr[j];
                    arr[j] ^= arr[j+1];
                    flag = true;
                }

            }
            if(!flag){
                break;
            }
        }
    }
}
