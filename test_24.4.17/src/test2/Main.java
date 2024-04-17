package test2;

import java.util.HashSet;

/**
 * ClassName: Main
 * Package: test2
 * Description:771. 宝石与石头
 *
 * @Author 行空XKong
 * @Create 2024/4/17 22:08
 * @Version 1.0
 */
public class Main {
}

class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        HashSet<Character> set = new HashSet<>();
        for (char ch : jewels.toCharArray()) {
            set.add(ch);
        }

        int count = 0;
        for (char ch : stones.toCharArray()) {
            if (set.contains(ch)) {
                ++count;
            }
        }
        return count;
    }
}