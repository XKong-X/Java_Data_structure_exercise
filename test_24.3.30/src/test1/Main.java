package test1;

import java.util.Stack;

/**
 * ClassName: Main
 * Package: test1
 * Description:155. 最小栈
 *
 * @Author 行空XKong
 * @Create 2024/3/30 17:54
 * @Version 1.0
 */
public class Main {
}

class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.empty()) {
            minStack.push(val);
        } else {
            int peekVal = minStack.peek();
            if (val <= peekVal) {
                minStack.push(val);
            }
        }

    }

    public void pop() {
        int val = stack.pop();
        if (!minStack.empty()) {
            if (val == minStack.peek()) {
                minStack.pop();
            }
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        if (!minStack.empty()) {
            return minStack.peek();
        }
        return -1;
    }
}
