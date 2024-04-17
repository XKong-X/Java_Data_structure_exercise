package hashbuck;

/**
 * ClassName: HashBuck
 * Package: hashbuck
 * Description:开散列/哈希桶(基础类型版)
 *
 * @Author 行空XKong
 * @Create 2024/4/17 11:47
 * @Version 1.0
 */
public class HashBuck {
    static class Node {
        public int key;
        public int val;
        public Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public Node[] array;
    public int usedSize;
    public static final float DEFAULT_LOAD_FACTOR = 0.75f;

    public HashBuck() {
        array = new Node[10];
    }

    public void put(int key, int val) {
        int index = key % array.length;//计算存储位置
        Node prev = array[index];
        Node cur = array[index];
        while (cur != null) {
            if (cur.key == key) {
                cur.val = val;
                return;
            }
            prev = cur;
            cur = cur.next;
        }

        //cur == null,未找到key,尾插法
        if (array[index] == null) {
            array[index] = new Node(key, val);
        } else {
            prev.next = new Node(key, val);
        }

        ++usedSize;

        //判断负载系数
        if (doLoadFactor() > DEFAULT_LOAD_FACTOR) {
            //扩容并调整
            resize();
        }
    }

    private void resize() {
        Node[] newArray = new Node[array.length * 2];
        //遍历数组
        for (int i = 0; i < array.length; ++i) {
            Node tmp = array[i];
            Node prev = array[i];
            //遍历每个节点的链表
            while (tmp != null) {
                Node tmpNext = tmp.next;//记录tmp的下一个节点的位置
                tmp.next = null;//把next域置为空，避免把整个链表带过去
                int index = tmp.key % newArray.length;//重新计算存储位置
                if (newArray[index] == null) {
                    newArray[index] = tmp;
                } else {
                    prev.next = tmp;
                    prev = tmp;
                }
                tmp = tmpNext;
            }
        }
        array = newArray;
    }

    private float doLoadFactor() {
        return usedSize * 1.0f / array.length;
    }

    public int get(int key) {
        int index = key % array.length;
        Node cur = array[index];
        while (cur != null) {
            if (cur.key == key) {
                return cur.val;
            }
            cur = cur.next;
        }
        return -1;
    }
}
