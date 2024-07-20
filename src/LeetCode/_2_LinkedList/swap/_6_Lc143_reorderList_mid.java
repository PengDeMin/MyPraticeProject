package LeetCode._2_LinkedList.swap;

import LeetCode._2_LinkedList.Utils.ListNode;
import LeetCode._2_LinkedList.Utils.SingleLinkedList;

/**
 * @ClassName _6_Lc143_reorderList_mid
 * @Author Demin Peng
 * @Date 2024/7/20 17:13
 * @Description 重排链表O
 */

public class _6_Lc143_reorderList_mid {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        Object[] valsArray = Arrays.stream(scanner.nextLine().split(",")).toArray();
//        int k = scanner.nextInt();
        int[] valsArray = new int[]{7,9,8,7};

        SingleLinkedList linkedList = new SingleLinkedList(valsArray);
        reorderList(linkedList.head);
        linkedList.displayFromOwn();
    }

    public static void reorderList(ListNode head) {
        //TODO
    }
}
