package LeetCode._2_LinkedList.Utils;

/**
 * @Author：彭德民
 * @ClassName：ListNode
 * @Date：2024/7/18 19:55
 * @Description：单列表节点定义
 */

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode prev;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode() {
    }


    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }


    public ListNode(int val, ListNode next, ListNode prev) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}
