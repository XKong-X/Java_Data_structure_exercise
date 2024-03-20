package test1;

/**
 * ClassName: Main
 * Package: test1
 * Description:203. 移除链表元素
 *
 * @Author 行空XKong
 * @Create 2024/3/20 13:57
 * @Version 1.0
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        //判断是否为空
        if (head == null) {
            return null;
        }
        ListNode prev = head;
        ListNode tmp = head.next;
        while (tmp != null) {
            if (tmp.val == val) {
                prev.next = tmp.next;
                tmp = tmp.next;
            } else {
                prev = tmp;
                tmp = tmp.next;
            }
            //tmp = tmp.next;
        }
        //判断第一个节点
        if (head.val == val) {
            head = head.next;
        }
        return head;
    }
}