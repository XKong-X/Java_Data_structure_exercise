package test2;

import java.util.Stack;

/**
 * ClassName: Main
 * Package: test2
 * Description:234. 回文链表
 *
 * @Author 行空XKong
 * @Create 2024/5/15 18:18
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

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head.next == null) {
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        if (!(fast == null)) {
            //fast.next == null，slow 需要多往后走一步
            slow = slow.next;
        }
        while (/*!stack.empty() && */slow != null) {
            if (stack.pop() != slow.val) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }
}