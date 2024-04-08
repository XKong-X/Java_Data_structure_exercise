/**
 * ClassName: Sort
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author 行空XKong
 * @Create 2024/4/8 23:28
 * @Version 1.0
 */
public class Sort {
    /**
     * 插入排序
     * 时间复杂度：
     *    最坏情况：O(n^2)
     *    最好情况：O(n)
     * 空间复杂度：O(1)
     * 稳定性：稳定
     * @param arr
     */
    public static void insertSort(int[] arr) {
        //默认第一个元素有序
        for (int i = 1; i < arr.length; ++i) {
            int tmp = arr[i];
            for (int j = i - 1; j >= 0 ; --j) {
                //升序
                if (tmp < arr[j]) {
                    arr[j + 1] = arr[j];
                } else {
                    arr[j + 1] = tmp;
                    break;
                }
            }
        }
    }
}
