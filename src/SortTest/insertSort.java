package SortTest;

/**
 * @ClassName insertSort
 * @Author Demin Peng
 * @Date 2024/9/27 11:51
 * @Description 插入排序-直接插入-正序
 * 时间复杂度最佳O(n),最坏O(n^2),平均O(n^2)
 */

public class insertSort {
    public static void main(String[] args)
    {
        int[] arr = {3, 2, 1, 5, 6, 4};
        insertSort(arr);
    }

    public static void insertSort(int[] arr)
    {
        for(int i =1;i< arr.length;i++){
            int preIndex = i-1;
            int current = arr[i];
            while(preIndex>=0 && current < arr[preIndex]){
                arr[preIndex+1] = arr[preIndex];
                preIndex -= 1;
            }
            //上面的while循环结束后，preIndex+1就是当前元素应该插入的位置
            //因为preIndex那个位置的元素已经比current小了，
            arr[preIndex+1] = current;
        }
    }
}
