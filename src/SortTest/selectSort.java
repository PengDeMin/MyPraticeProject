package SortTest;

/**
 * @ClassName selectSort
 * @Author Demin Peng
 * @Date 2024/9/27 12:09
     * @Description 选择排序，时间复杂度最佳O(n^2)，空间复杂度O(1)
 */

public class selectSort {
    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 6, 4};
        selectSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static void selectSort(int[] arr) {
        for(int i =0;i<arr.length-1;i++) {
            int minIndex = i;
            for(int j = i+1;j<arr.length;j++){
                if (arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }

            if(minIndex != i){
                int tmp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = tmp;
            }
        }
    }
}
