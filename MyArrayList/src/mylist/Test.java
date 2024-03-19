package mylist;

/**
 * ClassName: Test
 * Package: mylist
 * Description:测试类
 *
 * @Author 行空XKong
 * @Create 2024/3/19 10:59
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(99);
        myArrayList.display();

        myArrayList.set(0, 88);
        myArrayList.display();

        myArrayList.remove(2);
        myArrayList.display();
        myArrayList.clear();
    }
}
