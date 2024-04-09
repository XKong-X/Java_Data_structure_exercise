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
     * 最坏情况：O(n^2)
     * 最好情况：O(n)
     * 空间复杂度：O(1)
     * 稳定性：稳定
     *
     * @param arr
     */
    public static void insertSort(int[] arr) {
        //默认第一个元素有序
        for (int i = 1; i < arr.length; ++i) {
            int tmp = arr[i];
            int j = i - 1;
            for (; j >= 0; --j) {
                //升序
                if (tmp < arr[j]) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = tmp;
        }
    }

    /**
     * 希尔排序(缩小增量排序)
     * 时间复杂度：约O(n^1.3)
     * 空间复杂度：O(1)
     * 稳定性：不稳定
     * @param arr
     */
    public static void shellSort(int[] arr) {
        int gap = arr.length;
        while (gap > 1) {
            gap /= 2;
            shell(arr, gap);
        }
    }

    /**
     * 对每组进行插入排序
     *
     * @param arr
     * @param gap
     */
    private static void shell(int[] arr, int gap) {
        //默认第一个元素有序
        for (int i = gap; i < arr.length; ++i) {
            int tmp = arr[i];
            int j = i - gap;
            for (; j >= 0; j -= gap) {
                //升序
                if (tmp < arr[j]) {
                    arr[j + gap] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + gap] = tmp;
        }
    }
}
