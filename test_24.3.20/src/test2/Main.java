package test2;

/**
 * ClassName: Main
 * Package: test2
 * Description:206. 反转链表
 *
 * @Author 行空XKong
 * @Create 2024/3/20 21:20
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
    public ListNode reverseList(ListNode head) {
        //为空
        if (head == null) {
            return head;
        }
        //只有一个节点
        if (head.next == null) {
            return head;
        }
        ListNode tmp = head.next;
        head.next = null;
        while (tmp != null) {
            ListNode tmpNext = tmp.next;
            tmp.next = head;
            head = tmp;
            tmp = tmpNext;
        }
        return head;
    }
}