package test2;

/**
 * ClassName: Main
 * Package: test2
 * Description:CM11 链表分割
 *
 * @Author 行空XKong
 * @Create 2024/3/21 23:08
 * @Version 1.0
 */
public class Main {
}
class Partition {
    public ListNode partition(ListNode pHead, int x) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode bs = null;
        ListNode be = null;
        ListNode as = null;
        ListNode ae = null;
        ListNode tmp = pHead;
        //遍历
        while (tmp != null) {
            if (tmp.val < x) {
                if (bs == null) {//插入第一个数据
                    bs = tmp;
                    be = tmp;
                } else {
                    be.next = tmp;
                    be = be.next;
                }
            } else {
                if (as == null) {//插入第一个数据
                    as = tmp;
                    ae = tmp;
                } else {
                    ae.next = tmp;
                    ae = ae.next;
                }
            }
            tmp = tmp.next;
        }
        //将链表重新串起来
        if (bs == null) {//第一个区间没数据
            return as;
        }
        //第一个区间有数据
        be.next = as;
        if (as != null) {//第二个区间有数据
            ae.next = null;
        }
        //return pHead;要求返回[重新排列后的链表的头指针]，所以不能返回pHead,要返回bs
        return bs;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
