package test5;

/**
 * ClassName: Main
 * Package: test5
 * Description:21. 合并两个有序链表
 *
 * @Author 行空XKong
 * @Create 2024/3/20 23:29
 * @Version 1.0
 */
public class Main {
}

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newHead = new ListNode();
        ListNode tmp = newHead;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tmp.next = list1;
                list1 = list1.next;
            } else {
                tmp.next = list2;
                list2 = list2.next;
            }
            tmp = tmp.next;
        }
        if (list1 == null) {
            tmp.next = list2;
        }
        if (list2 == null) {
            tmp.next = list1;
        }
        return newHead.next;
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
