package test1;

/**
 * ClassName: Main
 * Package: test1
 * Description:
 *
 * @Author 行空XKong
 * @Create 2024/3/25 23:55
 * @Version 1.0
 */
public class Main {
}

class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        //假设a长b短
        ListNode tmpL = headA;
        ListNode tmpS = headB;
        while (tmpL != null) {
            tmpL = tmpL.next;
            ++lenA;
        }
        while (tmpS != null) {
            tmpS = tmpS.next;
            ++lenB;
        }
        tmpL = headA;
        tmpS = headB;
        int len = lenA - lenB;
        //调整
        if (len < 0) {
            len = -len;
            tmpL = headB;
            tmpS = headA;
        }
        //对齐
        while (len != 0) {
            tmpL = tmpL.next;
            --len;
        }
        //并列同时遍历
        while (tmpL != tmpS) {
            tmpL = tmpL.next;
            tmpS = tmpS.next;
        }
        if (tmpL == null) {//判断是否未相遇（不判断也行）
            return null;
        }
        return tmpL;//返回tmpS也是一样的
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
