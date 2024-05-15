package test4;

import java.util.Stack;

/**
 * ClassName: Main
 * Package: test4
 * Description:LCR 123. 图书整理 I
 *
 * @Author 行空XKong
 * @Create 2024/5/15 20:05
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
    // // 方法一（递归）
    // private int index;

    // public int[] reverseBookList(ListNode head) {
    //     if (head == null) {
    //         return new int[]{};
    //     }
    //     if (head.next == null) {
    //         return new int[]{head.val};
    //     }
    //     // 求链表长度
    //     int len = 0;
    //     ListNode tmp = head;
    //     while (tmp != null) {
    //         ++len;
    //         tmp = tmp.next;
    //     }

    //     int[] bookList = new int[len];
    //     reverseTraversal(bookList, head);
    //     return bookList;
    // }

    // private void reverseTraversal(int[] bookList, ListNode tmp) {
    //     if (tmp == null) {
    //         return;
    //     }
    //     reverseTraversal(bookList, tmp.next);
    //     bookList[index++] = tmp.val;
    // }

    // 方法二（利用栈来完成）
    public int[] reverseBookList(ListNode head) {
        if (head == null) {
            return new int[]{};
        }
        if (head.next == null) {
            return new int[]{head.val};
        }
        // 求链表长度并将 val 入栈
        int len = 0;
        ListNode tmp = head;
        Stack<Integer> stack = new Stack<>();
        while (tmp != null) {
            ++len;
            stack.push(tmp.val);
            tmp = tmp.next;
        }

        // 将栈中数据放入数组中
        int[] bookList = new int[len];
        for (int i = 0; i < len; ++i) {
            bookList[i] = stack.pop();
        }
        return bookList;
    }
}