import hashbuck.HashBuck;

/**
 * ClassName: Test
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author 行空XKong
 * @Create 2024/4/17 11:47
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        HashBuck hashBuck = new HashBuck();
        hashBuck.put(1,11);
        hashBuck.put(2,22);
        hashBuck.put(9,99);
        hashBuck.put(19,99);
        hashBuck.put(5,55);
        hashBuck.put(6,66);
        hashBuck.put(7,77);
        //hashBuck.put(8,888);
        hashBuck.put(4,44);

        System.out.println(hashBuck.get(19));
        System.out.println();
    }
}
