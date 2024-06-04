package tes1;

import java.util.HashMap;
import java.util.Map;

public class Main {
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer ,Integer> map = new HashMap<>();
        int[] ret = new int[]{-1, -1};
        for (int i = 0; i < nums.length; ++i) {
            int num = target - nums[i];
            if (map.containsKey(num)) {
                ret[0] = map.get(num);
                ret[1] = i;
                return ret;
            }
            map.put(nums[i], i);
        }
        return ret;
    }
}