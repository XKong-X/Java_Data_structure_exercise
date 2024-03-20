/**
 * ClassName: MySingleList
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author 行空XKong
 * @Create 2024/3/19 21:14
 * @Version 1.0
 */
public class MySingleList implements IList {
    static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode head;

//    public void createList() {
//        ListNode listNode1 = new ListNode(1);
//        ListNode listNode2 = new ListNode(2);
//        ListNode listNode3 = new ListNode(3);
//        ListNode listNode4 = new ListNode(4);
//        ListNode listNode5 = new ListNode(5);
//
//        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//        listNode3.next = listNode4;
//        listNode4.next = listNode5;
//
//        this.head = listNode1;
//    }

    @Override
    public void addFirst(int data) {
        ListNode listNode = new ListNode(data);
//        if (this.head == null) {
//            this.head = listNode;
//            return;
//        }
        listNode.next = this.head;
        this.head = listNode;
    }

    @Override
    public void addLast(int data) {
        ListNode listNode = new ListNode(data);
        ListNode tmp = this.head;
        if (tmp == null) {
            this.head = listNode;
        } else {
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = listNode;
        }
    }

    @Override
    public void addIndex(int index, int data) {
        if (index < 0 || index > size()) {
            throw new IndexIllegality("插入元素位置异常:" + index);
        }
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == size()) {
            addLast(data);
            return;
        }
        ListNode tmp = searchPrev(index);
        ListNode listNode = new ListNode(data);
        listNode.next = tmp.next;
        tmp.next = listNode;
    }

    private ListNode searchPrev(int index) {
        ListNode tmp = this.head;
        while (index - 1 != 0) {
            tmp = tmp.next;
            --index;
        }
        return tmp;
    }

    @Override
    public boolean contains(int key) {
        ListNode tmp = this.head;
        while (tmp != null) {
            if (tmp.val == key) {
                return true;
            }
            tmp = tmp.next;
        }
        return false;
    }

    @Override
    public void remove(int key) {
//        if (this.head == null) {
//            System.out.println("当前链表无数据，无法进行删除！");
//            return;
//        }
        if (isEmpty()) {
            return;
        }

        if (this.head.val == key) {
            this.head = this.head.next;
            return;
        }

        ListNode tmp = findPrev(key);
        if (tmp == null) {
            System.out.println("要删除的数不存在！");
            return;
        }
        ListNode del = tmp.next;
        tmp.next = del.next;
    }

    private boolean isEmpty() {
        if (this.head == null) {
            System.out.println("当前链表无数据，无法进行删除！");
            return true;
        }
        return false;
    }

    private ListNode findPrev(int key) {
        ListNode tmp = this.head;
        while (tmp.next != null) {
            if (tmp.next.val == key) {
                return tmp;
            }
            tmp = tmp.next;
        }
        return null;
    }

    @Override
    public void removeAllKey(int key) {
        if (isEmpty()) {
            return;
        }
        ListNode prev = this.head;
        ListNode tmp = this.head.next;
        while (tmp != null) {
            if (tmp.val == key) {
                prev.next = tmp.next;
            } else {
                prev = tmp;
            }
            tmp = tmp.next;
        }
        if (this.head.val == key) {
            this.head = this.head.next;
        }
    }

    @Override
    public int size() {
        int count = 0;
        ListNode tmp = this.head;
        while (tmp != null) {
            ++count;
            tmp = tmp.next;
        }
        return count;
    }

    @Override
    public void clear() {
        ListNode tmp = this.head;
        this.head = null;
        while (tmp != null) {
            ListNode cur = tmp.next;
            tmp.next = null;
            tmp = cur;
        }
    }

    @Override
    public void display() {
        ListNode tmp = this.head;
        while (tmp != null) {
            System.out.print(tmp.val + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }

    public void display(ListNode newHead) {
        ListNode tmp = newHead;
        while (tmp != null) {
            System.out.print(tmp.val + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }

    public ListNode reverseList() {
        //为空
        if (this.head == null) {
            return null;
        }
        //只有一个节点
        if (this.head.next == null) {
            return this.head;
        }
        ListNode tmp = this.head.next;
        this.head.next = null;
        while (tmp != null) {
            ListNode tmpNext = tmp.next;
            tmp.next = this.head;
            this.head = tmp;
            tmp =tmpNext;
        }
        return this.head;
    }
}
