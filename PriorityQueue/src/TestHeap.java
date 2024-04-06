import java.util.Arrays;

/**
 * ClassName: TestHeap
 * Package: PACKAGE_NAME
 * Description:实现PriorityQueue（优先级队列即Heap（堆））
 *
 * @Author 行空XKong
 * @Create 2024/4/6 18:57
 * @Version 1.0
 */
public class TestHeap {
    public int[] elem;
    public int usedSize;

    public TestHeap() {
        this.elem = new int[10];
    }

    public void initElem(int[] arr) {
        usedSize = arr.length;
        this.elem = Arrays.copyOf(arr, usedSize);
    }

    public void createHeap() {
        for (int parent = (usedSize - 1 - 1) / 2; parent >= 0; --parent) {
            siftDown(parent, usedSize);
        }
    }

    private void siftDown(int parent, int len) {
        int child = 2 * parent + 1;//假设左树的值大于右树
        while (child < len) {
            if (child + 1 < len && elem[child] < elem[child + 1]) {
                child += 1;
            }
            //代码到这child一定是子树中值最大的下标
            if (elem[child] > elem[parent]) {
                //交换
                swap(parent, child);
                parent = child;
                child = 2 * parent + 1;
            } else {
                break;
            }
        }
    }

    private void swap(int i, int j) {
        int tmp = elem[i];
        elem[i] = elem[j];
        elem[j] = tmp;
    }

    public void push(int val) {
        if (isFull()) {
            elem = Arrays.copyOf(elem, usedSize * 2);//用usedSize以减少函数调用
        }
        elem[usedSize] = val;
        //先上调整
        siftUp(usedSize);
        ++usedSize;
    }

    private boolean isFull() {
        return usedSize == elem.length;
    }

    private void siftUp(int child) {
        int parent = (child - 1) / 2;
        while (child > 0) {//parent >= 0 和 child > 0任选一个条即可件
            if (elem[child] > elem[parent]) {
                swap(child, parent);
                child = parent;
                parent = (child - 1) / 2;
            } else {
                break;
            }
        }
    }

    public int pop() throws HeapEmptyException {
        if (empty()) {
            throw new HeapEmptyException("当前堆为空！");
        }
        int oldVal = elem[0];//保存优先级最高的元素
        swap(0, usedSize - 1);
        --usedSize;
        siftDown(0, usedSize);
        return oldVal;
    }

    public boolean empty() {
        return usedSize == 0;
    }

    public int peek() {
        return elem[0];
    }
}
