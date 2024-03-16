package test1;

/**
 * ClassName: Main
 * Package: test1
 * Description:27. 移除元素
 *
 * @Author 行空XKong
 * @Create 2024/3/16 20:03
 * @Version 1.0
 */
public class Main {
    //    //方法一（从右边开始找）
//    public int removeElement(int[] nums, int val) {
//        int delNumScope = nums.length - 1;
//        int usedSize = nums.length;
//        while (true) {
//            //小于0说明已经删完了
//            if (delNumScope < 0) {
//                return usedSize;
//            }
//            //找要删除的数字
//            while (nums[delNumScope] != val) {
//                --delNumScope;
//                //小于0说明已经删完了
//                if (delNumScope < 0) {
//                    return usedSize;
//                }
//            }
//            //处理
//            nums[delNumScope] = nums[usedSize - 1];
//            --delNumScope;
//            --usedSize;
//        }
//    }
    //方法二（从左边开始找）
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[right - 1];
                right--;
            } else {
                left++;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        int len = new Main().removeElement(nums, val);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
