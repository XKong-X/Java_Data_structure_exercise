/**
 * ClassName: TestLink
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author 行空XKong
 * @Create 2024/3/26 19:20
 * @Version 1.0
 */
public class TestLink {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addLast(1);
        myLinkedList.addLast(2);
        myLinkedList.addLast(3);
        myLinkedList.addLast(4);
        myLinkedList.addLast(1);

        myLinkedList.addIndex(2, 1);
        myLinkedList.display();
        myLinkedList.removeAllKey(1);
        myLinkedList.display();

    }
}
