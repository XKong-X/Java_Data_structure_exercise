package test3;

import java.util.*;

/**
 * ClassName: Main
 * Package: test3
 * Description:[编程题]旧键盘 (20)
 *
 * @Author 行空XKong
 * @Create 2024/4/17 22:44
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String str1 = in.nextLine();
            String str2 = in.nextLine();
            func(str1, str2);
        }
    }

    private static void func(String str1, String str2) {
        HashSet<Character> set2 = new HashSet<>();
        for (char ch : str2.toUpperCase().toCharArray()) {
            set2.add(ch);
        }
        HashSet<Character> set = new HashSet<>();
        for (char ch : str1.toUpperCase().toCharArray()) {
            if (!set2.contains(ch) && !set.contains(ch)) {
                System.out.print(ch);
                set.add(ch);
            }
        }
    }
}