package test2;

import java.util.Stack;

/**
 * ClassName: Main
 * Package: test2
 * Description:232. 用栈实现队列
 *
 * @Author 行空XKong
 * @Create 2024/3/31 17:45
 * @Version 1.0
 */
public class Main {
}

class MyQueue {
    private Stack<Integer> s1;
    private Stack<Integer> s2;

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        s1.push(x);
    }

    public int pop() {
        if (empty()) {
            return -1;
        }
        if (s2.empty()) {
            while (!s1.empty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

    public int peek() {
        if (empty()) {
            return -1;
        }
        if (s2.empty()) {
            while (!s1.empty()) {
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }

    public boolean empty() {
        return s1.empty() && s2.empty();
    }
}
