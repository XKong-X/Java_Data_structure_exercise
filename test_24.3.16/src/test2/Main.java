package test2;

/**
 * ClassName: Main
 * Package: test2
 * Description:26. 删除有序数组中的重复项
 *
 * @Author 行空XKong
 * @Create 2024/3/16 21:38
 * @Version 1.0
 */
class Solution {
//    //方法一
//    public int removeDuplicates(int[] nums) {
//        int l = 0;
//        int r = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[l] == nums[r]) {
//                ++r;
//            } else {
//                nums[++l] = nums[r++];
//            }
//        }
//        return ++l;
//    }
    //方法二（将方法一进一步减少代码）
    public int removeDuplicates(int[] nums) {
        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            if (nums[l] != nums[r]) {
                nums[++l] = nums[r];
            }
        }
        return ++l;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4}; // 输入数组
        int[] expectedNums = {0, 1, 2, 3, 4}; // 长度正确的期望答案
        int k = new Solution().removeDuplicates(nums); // 调用
        assert k == expectedNums.length;
        for (int i = 0; i < k; i++) {
            assert nums[i] == expectedNums[i];
            System.out.print(nums[i] + " ");
        }
    }
}
