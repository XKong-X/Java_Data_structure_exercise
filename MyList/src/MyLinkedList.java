/**
 * ClassName: MyLinkedList
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author 行空XKong
 * @Create 2024/3/26 18:55
 * @Version 1.0
 */
public class MyLinkedList implements IList {
    static class ListNode {
        public int val;
        public ListNode next;
        public ListNode prev;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode head;
    public ListNode last;
    @Override
    public void addFirst(int data) {
        ListNode tmp = new ListNode(data);
        if (this.head == null) {
            this.head = tmp;
            this.last = tmp;
        } else {
            tmp.next = this.head;
            this.head.prev = tmp;
            this.head = tmp;
        }
    }

    @Override
    public void addLast(int data) {
        ListNode tmp = new ListNode(data);
        if (this.last == null) {
            this.head = tmp;
            this.last = tmp;
        } else {
            last.next = tmp;
            tmp.prev = this.last;
            this.last = tmp;
        }
    }

    @Override
    public void addIndex(int index, int data) throws IndexIllegality {
        int len = size();
        if (index < 0 || index > len) {
            throw new IndexIllegality("插入元素位置异常:" + index);
        }
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == len) {
            addLast(data);
            return;
        }
        ListNode tmp = findIndex(index);
        ListNode listNode = new ListNode(data);
        listNode.next = tmp;
        tmp.prev.next = listNode;
        listNode.prev = tmp.prev;
        tmp.prev = listNode;
    }

    private ListNode findIndex(int index) {
        ListNode tmp = this.head;
        while (index != 0) {
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
        if (isEmpty()) {
            return;
        }
        if (this.head.val == key) {
            this.head = this.head.next;
            if (this.head != null) {
                this.head.prev = null;
            }
            return;
        }
        if (this.last.val == key) {
            this.last = this.last.prev;
            if (this.last != null) {
                this.last.next = null;
            }
            return;
        }
        ListNode tmp = findKey(key);
        if (tmp == null) {
            System.out.println("要删除的数不存在！");
            return;
        }
        tmp.prev.next = tmp.next;
        tmp.next.prev = tmp.prev;
    }

    private ListNode findKey(int key) {
        ListNode tmp = this.head;
        while (tmp != null) {
            if (tmp.val == key) {
                return tmp;
            }
            tmp = tmp.next;
        }
        return null;
    }

    private boolean isEmpty() {
        if (this.head == null) {
            System.out.println("当前链表无数据，无法进行删除！");
            return true;
        }
        return false;
    }

    @Override
    public void removeAllKey(int key) {
        ListNode tmp = this.head;
        while (tmp != null) {
            if (tmp.val == key) {
                if (tmp == this.head) {
                    this.head = this.head.next;
                    if (this.head == null) {
                        this.last = null;
                    } else {
                        this.head.prev = null;
                    }
                } else {
                    tmp.prev.next = tmp.next;
                    if (tmp.next == null) {
                        this.last = this.last.prev;
                    } else {
                        tmp.next.prev = tmp.prev;
                    }
                }
            }
            tmp = tmp.next;
        }
    }

    @Override
    public int size() {
        ListNode tmp = this.head;
        int count = 0;
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
        this.last = null;
        while (tmp != null) {
            ListNode cur = tmp.next;
            tmp.next = null;
            tmp.prev = null;
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
}
