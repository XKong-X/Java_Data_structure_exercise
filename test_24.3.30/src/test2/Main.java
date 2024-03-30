package test2;

/**
 * ClassName: Main
 * Package: test2
 * Description:622. 设计循环队列
 *
 * @Author 行空XKong
 * @Create 2024/3/31 0:20
 * @Version 1.0
 */
public class Main {
}

class MyCircularQueue {
    private int[] elem;
    public int front;//队头
    public int rear; //队尾

    public MyCircularQueue(int k) {
        elem = new int[k + 1];
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        elem[rear] = value;
        rear = (rear + 1) % elem.length;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % elem.length;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return elem[front];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        int index = (rear == 0) ? elem.length - 1 : rear - 1;
        return elem[index];
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return (rear + 1) % elem.length == front;
    }
}