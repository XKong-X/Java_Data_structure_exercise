package test2;

/**
 * Created with IntelliJ IDEA.
 * Description: LCR 142. 训练计划 IV
 * Author: 行空XKong
 * Date: 2024-06-23
 * Time: 1:38
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
    public ListNode trainningPlan(ListNode l1, ListNode l2) {
        // // 方法一（递归）
        // if (l1 == null) {
        //     return l2;
        // } else if (l2 == null) {
        //     return l1;
        // } else if (l1.val < l2.val) {
        //     l1.next = trainningPlan(l1.next, l2);
        //     return l1;
        // } else {
        //     l2.next = trainningPlan(l1, l2.next);
        //     return l2;
        // }

        // 方法二（迭代）
        ListNode newHead = new ListNode(-1);
        ListNode node = newHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                node.next = l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }
        if (l1 != null) {
            node.next = l1;
        }
        if (l2 != null) {
            node.next = l2;
        }
        // 去掉表头
        return newHead.next;
    }
}
