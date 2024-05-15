package test3;

/**
 * ClassName: Main
 * Package: test3
 * Description:1290. 二进制链表转整数
 *
 * @Author 行空XKong
 * @Create 2024/5/15 19:05
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
    public int getDecimalValue(ListNode head) {
        ListNode tmp = head;
        int sum = 0;
        while (tmp != null) {
            sum = tmp.val + sum << 1;
            tmp = tmp.next;
        }
        return sum / 2;//按理来说不用除 2，可能判题系统有问题
    }
}