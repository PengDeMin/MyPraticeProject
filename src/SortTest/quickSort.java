package SortTest;

import java.util.Arrays;

/**
 * @ClassName quickSort
 * @Author Demin Peng
 * @Date 2024/9/27 11:14
 * @Description 交换类-快速排序：分治思想-时间复杂度最佳O(nlogn)，最差O(n^2)，平均时间复杂度O(n)
 * 空间复杂度O(logn)
 * 通过一趟排序将待排序列分隔成独立的两部分，
 * 其中一部分记录的元素均比另一部分的元素小，则可分别对这两部分子序列继续进行排序，以达到整个序列有序
 */

public class quickSort {
    public static void main(String[] args)
    {
        int[] arr = {3, 2, 1, 5, 6, 4};
        quickSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    static void quickSort(int[] arr,int start,int end){
        if(start<end){
            int position = partition(arr,start,end);
            //对基准值左边的子序列递归快排
            quickSort(arr,start,position-1);
            //对基准值右边的子序列递归快排
            quickSort(arr,position+1,end);
        }
    }

    static int partition(int [] arr,int start,int end){
        //以右端的数为基准值
        int pivot = arr[end];
        //以左端端的数作为游标
        int index = start;
        for(int i=start; i<end;i++){
            if(arr[i]<=pivot){
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index++]=temp;
//                arr[i] ^= arr[index];
//                arr[index] ^= arr[i];
//                arr[i] ^= arr[index++];
            }
            System.out.println(Arrays.toString(arr));
        }

        //经过上面的for循环，index所指的位置应该就是基准值元素的正确位置，因此交换元素
        //然后返回这个基准值的位置，代表这个基准值左边的元素都比它小，右边的元素都比它大
//        arr[index] ^= arr[end];
//        arr[end] ^= arr[index];
//        arr[index] ^= arr[end];

        int temp = arr[index];
        arr[index] = arr[end];
        arr[end] = temp;
        return index;
    }
}
