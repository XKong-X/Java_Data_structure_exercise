package hashbuck;

import java.util.Objects;

/**
 * ClassName: GenericHashBucket
 * Package: hashbuck
 * Description:开散列/哈希桶(泛型版)
 *
 * @Author 行空XKong
 * @Create 2024/4/17 20:49
 * @Version 1.0
 */
class Student {
    public String id;

    public Student(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

public class GenericHashBucket<K, V> {
    static class Node<K, V> {
        public K key;
        public V val;
        public Node<K, V> next;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    public Node<K, V>[] array;
    public int usedSize;
    public static final float DEFAULT_LOAD_FACTOR = 0.75f;

    public GenericHashBucket() {
        array = (Node<K, V>[]) new Node[10];
    }

    public void put(K key, V val) {
        int hash = key.hashCode();
        int index = hash % array.length;//计算存储位置
        Node<K, V> prev = array[index];
        Node<K, V> cur = array[index];
        while (cur != null) {
            if (key.equals(cur.key)) {
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

    private float doLoadFactor() {
        return usedSize * 1.0f / array.length;
    }

    private void resize() {
        Node<K, V>[] newArray = new Node[array.length * 2];
        //遍历数组
        for (int i = 0; i < array.length; ++i) {
            Node<K, V> tmp = array[i];
            Node<K, V> prev = array[i];
            //遍历每个节点的链表
            while (tmp != null) {
                Node<K, V> tmpNext = tmp.next;//记录tmp的下一个节点的位置
                tmp.next = null;//把next域置为空，避免把整个链表带过去
                int hash = tmp.key.hashCode();
                int index = hash % newArray.length;//重新计算存储位置
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

    public V getValue(K key) {
        int hash = key.hashCode();
        int index = hash % array.length;
        Node<K, V> cur = array[index];
        while (cur != null) {
            if (key.equals(cur.key)) {
                return cur.val;
            }
            cur = cur.next;
        }
        return null;
    }
}


