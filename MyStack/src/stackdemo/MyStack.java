package stackdemo;

import java.util.Arrays;

/**
 * ClassName: MyStack
 * Package: stackdemo
 * Description:
 *
 * @Author 行空XKong
 * @Create 2024/3/27 19:57
 * @Version 1.0
 */
public class MyStack implements IStack {
    private int[] elem;
    private int usedSize;
    private static final int DEFAULT_CAPACITY = 10;

    public MyStack() {
        elem = new int[DEFAULT_CAPACITY];
    }

    @Override
    public void push(int x) {
        if (full()) {
            elem = Arrays.copyOf(elem, elem.length * 2);
        }
        elem[usedSize] = x;
        ++usedSize;
    }

    @Override
    public int pop() {
        if (empty()) {
            throw new EmptyException("栈是空的！");
        }
        int tmp = elem[usedSize - 1];
        --usedSize;
        return tmp;
    }

    @Override
    public int peek() {
        return elem[usedSize - 1];
    }

    @Override
    public int size() {
        return usedSize;
    }

    @Override
    public boolean empty() {
        return usedSize == 0;
    }

    @Override
    public boolean full() {
        if (this.usedSize == this.elem.length) {
            return true;
        }
        return false;
    }
}
