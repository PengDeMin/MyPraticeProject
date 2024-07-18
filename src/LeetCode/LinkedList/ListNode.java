package LeetCode.LinkedList;

import java.util.List;

/**
 * @Author：彭德民
 * @ClassName：ListNode
 * @Date：2024/7/17 19:33
 * @Description：模拟链表
 */

public class ListNode {
    int val;

    ListNode next;

    ListNode() {}

    ListNode(int val){
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
