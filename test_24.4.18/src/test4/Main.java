package test4;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: Main
 * Package: test4
 * Description:219. 存在重复元素 II
 *
 * @Author 行空XKong
 * @Create 2024/4/18 23:29
 * @Version 1.0
 */
public class Main {
}

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            int key = nums[i];
            //map.get(key)取出来的val值是在i之前存进去的，一定比i小，因此不用取绝对值
            if (map.containsKey(key) && i - map.get(key) <= k) {
                return true;
            }
            map.put(key, i);
        }
        return false;
    }
}