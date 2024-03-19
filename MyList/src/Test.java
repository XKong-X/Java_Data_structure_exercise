/**
 * ClassName: Test
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author 行空XKong
 * @Create 2024/3/19 21:13
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        MySingleList mySingleList = new MySingleList();
        //mySingleList.createList();
        mySingleList.display();

        System.out.println(mySingleList.size());

        System.out.println(mySingleList.contains(5));

        mySingleList.addFirst(22);
        mySingleList.addLast(33);
        mySingleList.addFirst(11);
        mySingleList.display();

        mySingleList.addIndex(3, 44);
        mySingleList.display();

        mySingleList.remove(0);
        mySingleList.display();
    }
}
