package hashbuck;

import java.util.HashMap;

/**
 * ClassName: Test2
 * Package: hashbuck
 * Description:
 *
 * @Author 行空XKong
 * @Create 2024/4/17 21:27
 * @Version 1.0
 */
public class Test2 {
    public static void main(String[] args) {
        Student student1 = new Student("61012345");
        Student student2 = new Student("61012345");

        GenericHashBucket<Student, Integer> genericHashBucket =
                new GenericHashBucket<>();
        genericHashBucket.put(student1, 10);
        Integer v = genericHashBucket.getValue(student2);
        System.out.println(v);
    }
}
