package test1;

import java.util.HashSet;

/**
 * ClassName: Main
 * Package: test1
 * Description:136. 只出现一次的数字(泛型练习)
 *
 * @Author 行空XKong
 * @Create 2024/4/17 21:56
 * @Version 1.0
 */
public class Main {
}

class Solution {
    public int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
            } else {
                set.remove(nums[i]);
            }
        }

        for (int i = 0; i < nums.length; ++i) {
            if (set.contains(nums[i])) {
                return nums[i];
            }
        }
        return -1;
    }
}