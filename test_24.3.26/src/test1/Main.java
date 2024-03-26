package test1;

/**
 * ClassName: Main
 * Package: test1
 * Description:141. 环形链表
 *
 * @Author 行空XKong
 * @Create 2024/3/26 13:42
 * @Version 1.0
 */
public class Main {
}

class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
