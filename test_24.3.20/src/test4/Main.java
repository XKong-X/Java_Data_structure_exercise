package test4;

/**
 * ClassName: Main
 * Package: test4
 * Description:输入一个链表，输出该链表中倒数第k个结点
 *
 * @Author 行空XKong
 * @Create 2024/3/20 22:14
 * @Version 1.0
 */
public class Main {
}
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }
}
class Solution {
    public ListNode findKthToTail(ListNode head, int k) {
        if (k <= 0 || head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (k - 1 != 0) {
            fast = fast.next;
            //处理k过大的问题
            if (fast == null) {
                return null;
            }
            --k;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}