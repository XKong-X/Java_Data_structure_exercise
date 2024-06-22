package test1;

/**
 * Created with IntelliJ IDEA.
 * Description: LCR 140. 训练计划 II
 * Author: 行空XKong
 * Date: 2024-06-23
 * Time: 0:36
 * Version:
 */
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
    public ListNode trainingPlan(ListNode head, int cnt) {
        // // 方法一
        // ListNode tmp = head;
        // int len = 0;
        // while (tmp != null) {
        //     tmp = tmp.next;
        //     ++len;
        // }
        // for (tmp = head; len > cnt; --len) {
        //     tmp = tmp.next;
        // }
        // return tmp;

        // 方法二（快慢指针）
        ListNode slow = head;
        ListNode fast = head;
        // fast 指针先走 cnt 步
        while (cnt > 0) {
            fast = fast.next;
            --cnt;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
