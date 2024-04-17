package test4;

import java.util.HashMap;

/**
 * ClassName: Main
 * Package: test4
 * Description:138. 随机链表的复制
 *
 * @Author 行空XKong
 * @Create 2024/4/17 23:09
 * @Version 1.0
 */
public class Main {
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node tmp = head;
        //遍历链表保存key和对应的val
        while (tmp != null) {
            Node node = new Node(tmp.val);
            map.put(tmp, node);
            tmp = tmp.next;
        }
        tmp = head;
        //通过key-val模型调整新链表的next和random的指向
        while (tmp != null) {
            map.get(tmp).next = map.get(tmp.next);
            map.get(tmp).random = map.get(tmp.random);
            tmp = tmp.next;
        }
        return map.get(head);
    }
}