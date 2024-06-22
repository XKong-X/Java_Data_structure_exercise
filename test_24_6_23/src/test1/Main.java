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
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}

class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // 方法一（迭代）
        if (head.next == null) {
            return head;
        }
        // 给链表增加一个头节点
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode prev = newHead;// 这里不能为 null 否则会空指针异常
        ListNode cur = head;
        // 找到要翻转的区间的起点
        for (int i = 1; i < m; ++i) {
            prev = cur;
            cur = cur.next;
        }
        // 完成指定区间内的翻转
        for (int i = m; i < n; ++i) {
            ListNode curNext = cur.next;
            cur.next = curNext.next;
            // System.out.println(cur == prev.next);// 第二次会输出 false 说明 cur != prev.next,因此不能用 cur
            curNext.next = prev.next;// prev 不会跟随 cur 往后移动
            prev.next = curNext;
        }
        // 返回时去掉表头
        return newHead.next;
    }
}
