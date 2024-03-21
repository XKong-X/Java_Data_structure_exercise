package test1;

/**
 * ClassName: Main
 * Package: test1
 * Description:OR36 链表的回文结构
 *
 * @Author 行空XKong
 * @Create 2024/3/21 21:00
 * @Version 1.0
 */
public class Main {
}
class PalindromeList {
    public boolean chkPalindrome(ListNode A) {
        //为空或只有一个节点
        if (A == null || A.next == null) {
            return true;
        }
        ListNode slow = A;
        ListNode fast = A;
        //找中间位置
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //翻转
        ListNode tmp = slow.next;
        while (tmp != null) {
            ListNode tmpNext = tmp.next;
            tmp.next = slow;
            slow = tmp;
            tmp = tmpNext;
        }
        //遍历比较
        while (A != slow) {
            if (A.val != slow.val) {
                return false;
            }
            //为节点为偶数个的情况判断
            if (A.next == slow) {
                return true;
            }
            A = A.next;
            slow = slow.next;
        }
        return true;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
