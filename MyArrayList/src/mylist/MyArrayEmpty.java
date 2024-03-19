package mylist;

/**
 * ClassName: PosIllegalityOnGet
 * Package: mylist
 * Description:
 *
 * @Author 行空XKong
 * @Create 2024/3/19 12:46
 * @Version 1.0
 */
public class MyArrayEmpty extends RuntimeException {
    public MyArrayEmpty(String msg) {
        super(msg);
    }
}
