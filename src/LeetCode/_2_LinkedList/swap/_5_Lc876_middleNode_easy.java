package LeetCode._2_LinkedList.swap;

import LeetCode._2_LinkedList.Utils.ListNode;
import LeetCode._2_LinkedList.Utils.SingleLinkedList;

/**
 * @ClassName _5_Lc876_middleNode_easy
 * @Author NewUser
 * @Date 2024/7/20 16:45
 * @Description 链表的中间节点
 * 给你单链表的头结点 head ，请你找出并返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 *
 * 输入：head = [1,2,3,4,5]
 * 输出：[3,4,5]
 * 解释：链表只有一个中间结点，值为 3 。
 *
 * 输入：head = [1,2,3,4,5,6]
 * 输出：[4,5,6]
 * 解释：该链表有两个中间结点，值分别为 3 和 4 ，返回第二个结点。
 */

public class _5_Lc876_middleNode_easy {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        Object[] valsArray = Arrays.stream(scanner.nextLine().split(",")).toArray();
//        int k = scanner.nextInt();
        int[] valsArray = new int[]{7,9,8,7};

        SingleLinkedList linkedList = new SingleLinkedList();
        ListNode head = linkedList.createListFromArray(valsArray);

        ListNode newHead = middleNode(head);
        linkedList.display(newHead);
    }

    public static ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(null != fast && null != fast.next){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
