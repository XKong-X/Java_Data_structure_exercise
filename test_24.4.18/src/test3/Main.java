package test3;

import java.util.HashSet;

/**
 * ClassName: Main
 * Package: test3
 * Description:217. 存在重复元素
 *
 * @Author 行空XKong
 * @Create 2024/4/18 22:57
 * @Version 1.0
 */
public class Main {
}

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
}