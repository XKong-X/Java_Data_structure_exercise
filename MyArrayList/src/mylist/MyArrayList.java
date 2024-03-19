package mylist;

import java.util.Arrays;

/**
 * ClassName: MyArrayList
 * Package: mylist
 * Description:MyArrayList主体
 *
 * @Author 行空XKong
 * @Create 2024/3/19 10:59
 * @Version 1.0
 */
public class MyArrayList implements IList {
    private int[] elem;
    private int usedSize;
    //顺序表默认大小
    public static final int DEFAULT_SIZE = 10;

    public MyArrayList(int elem) {
        this.elem = new int[elem];
    }

    public MyArrayList() {
        this.elem = new int[DEFAULT_SIZE];
    }

    @Override
    public void add(int data) {
        checkCapacity();
        this.elem[this.usedSize] = data;
        ++this.usedSize;
    }

    /**
     * 判断是否已满（仅做内部支持）
     */
    private boolean isFull() {
//        if (this.usedSize == this.elem.length) {
//            return true;
//        }
//        return false;
        return this.usedSize == this.elem.length;
    }

    /**
     * 检查是否需要进行扩容，需要则扩容（仅做内部支持）
     */
    private void checkCapacity() {
        if (isFull()) {
            this.elem = Arrays.copyOf(this.elem, this.elem.length * 2);
        }
    }

    @Override
    public void add(int pos, int data) {
        checkCapacity();
        try {
            checkPosOnAdd(pos);
        } catch (PosIllegality e) {
            e.printStackTrace();
            return;
        }
        for (int i = this.usedSize; i > pos; --i) {//把pos后的数据往后移动一格
            this.elem[i] = this.elem[i - 1];
        }
        this.elem[pos] = data;
        ++this.usedSize;
    }

    /**
     * 检查传入add的pos是否合法（仅做内部支持）
     */
    private void checkPosOnAdd(int pos) {
        if (pos < 0 || pos > usedSize) {
            throw new PosIllegality("插入元素下标异常:" + pos);
        }
    }

    @Override
    public boolean contains(int toFind) {
        if (isEmpty()) {
            return false;
        }
        for (int i = 0; i < this.usedSize; i++) {
            if (this.elem[i] == toFind) {
                return true;
            }
        }
        return false;
    }

    /**
     * 检查是否尚未存入数据（仅做内部支持）
     */
    private boolean isEmpty() {
        return this.usedSize == 0;
    }

    @Override
    public int indexOf(int toFind) {
        if (isEmpty()) {
            return -1;
        }
        for (int i = 0; i < this.usedSize; i++) {
            if (this.elem[i] == toFind) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int get(int pos) {
        checkPosOnGetAndSet(pos);//判断pos是否合法
        if (isEmpty()) {//判断顺序表是否为空
            throw new MyArrayEmpty("获取指定下标元素时，顺序表为空!");
        }
        return elem[pos];
    }

    /**
     * 检查传入get的pos是否合法（仅做内部支持）
     */
    private void checkPosOnGetAndSet(int pos) {
        if (pos < 0 || pos >= usedSize) {
            throw new PosIllegality("获取指定下标元素异常:" + pos);
        }
    }

    @Override
    public void set(int pos, int value) {
        checkPosOnGetAndSet(pos);
        elem[pos] = value;
    }

    @Override
    public void remove(int toRemove) {
        int index = indexOf(toRemove);
        if (index == -1) {
            System.out.println("未找到指定元素!");
            return;
        }
        for (int i = index; i < this.usedSize - 1; i++) {
            this.elem[i] = this.elem[i + 1];
        }
        --this.usedSize;
    }

    @Override
    public int size() {
        return this.usedSize;
    }

    @Override
    public void clear() {
        this.usedSize = 0;
    }

    @Override
    public void display() {
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i] + " ");
        }
        System.out.println();
    }
}
