package test3;

/**
 * ClassName: Main
 * Package: test3
 * Description:876. 链表的中间结点
 *
 * @Author 行空XKong
 * @Create 2024/3/20 22:05
 * @Version 1.0
 */
public class Main {
}

class Solution {
    // //方法一（要遍历1.5次链表）
    // public ListNode middleNode(ListNode head) {
    //     int count = 0;
    //     ListNode tmp = head;
    //     while (tmp != null) {
    //         tmp = tmp.next;
    //         ++count;
    //     }
    //     tmp = head;
    //     for (int i = 0; i < count / 2; ++i) {
    //         tmp = tmp.next;
    //     }
    //     return tmp;
    // }
    //方法二（快慢指针）
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
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
