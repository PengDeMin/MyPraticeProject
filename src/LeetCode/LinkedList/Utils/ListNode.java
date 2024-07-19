package LeetCode.LinkedList.Utils;

/**
 * @Author：彭德民
 * @ClassName：ListNode
 * @Date：2024/7/18 19:55
 * @Description：单列表节点定义
 */

public class ListNode<T> {
    public T val;
    public ListNode next;
    public ListNode prev;

    public ListNode(T val) {
        this.val = val;
    }

    public ListNode() {
    }


    public ListNode(T val, ListNode next) {
        this.val = val;
        this.next = next;
    }


    public ListNode(T val, ListNode next, ListNode prev) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}
