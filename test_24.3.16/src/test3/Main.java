package test3;

import java.util.Arrays;

/**
 * ClassName: Main
 * Package: test3
 * Description:88. 合并两个有序数组
 *
 * @Author 行空XKong
 * @Create 2024/3/16 22:49
 * @Version 1.0
 */
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        int r1 = m - 1;
        int r2 = n - 1;
        for (int i = m + n - 1; i >= 0; i--) {
            if (r1 < 0) {
                while (r2 >= 0) {
                    nums1[i--] = nums2[r2--];
                }
                return;
            }
            if (r2 < 0) {
                return;
            }
            if (nums1[r1] > nums2[r2]) {
                nums1[i] = nums1[r1--];
            } else {
                nums1[i] = nums2[r2--];
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        new Solution().merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
}
