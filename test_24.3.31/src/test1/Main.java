package test1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ClassName: Main
 * Package: test1
 * Description:225. 用队列实现栈
 *
 * @Author 行空XKong
 * @Create 2024/3/31 17:44
 * @Version 1.0
 */
public class Main {
}

class MyStack {
    private Queue<Integer> qu1;
    private Queue<Integer> qu2;

    public MyStack() {
        qu1 = new LinkedList<>();
        qu2 = new LinkedList<>();
    }

    public void push(int x) {
        if (!qu1.isEmpty()) {
            qu1.offer(x);
        } else if (!qu2.isEmpty()) {
            qu2.offer(x);
        } else {
            //都为空的情况下，默认放qu1
            qu1.offer(x);
        }
    }

    public int pop() {
        if (!qu1.isEmpty()) {
            int size = qu1.size();
            for (int i = 0; i < size - 1; ++i) {
                qu2.offer(qu1.poll());
            }
            return qu1.poll();
        } else if (!qu2.isEmpty()) {
            int size = qu2.size();
            for (int i = 0; i < size - 1; ++i) {
                qu1.offer(qu2.poll());
            }
            return qu2.poll();
        } else {
            //都为空的情况下，返回-1
            return -1;
        }
    }

    public int top() {
        if (!qu1.isEmpty()) {
            int size = qu1.size();
            int x = 0;
            for (int i = 0; i < size; ++i) {
                x = qu1.poll();
                qu2.offer(x);
            }
            return x;
        } else if (!qu2.isEmpty()) {
            int size = qu2.size();
            int x = 0;
            for (int i = 0; i < size; ++i) {
                x = qu2.poll();
                qu1.offer(x);
            }
            return x;
        } else {
            //都为空的情况下，返回-1
            return -1;
        }
    }

    public boolean empty() {
        return qu1.isEmpty() && qu2.isEmpty();
    }
}
