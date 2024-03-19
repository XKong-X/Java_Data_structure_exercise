package mylist;

/**
 * ClassName: PosIllegality
 * Package: mylist
 * Description:
 *
 * @Author 行空XKong
 * @Create 2024/3/19 11:51
 * @Version 1.0
 */
public class PosIllegality extends RuntimeException {
    public PosIllegality(String msg) {
        super(msg);
    }
}
