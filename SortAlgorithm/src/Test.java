import java.util.Arrays;
import java.util.Random;

/**
 * ClassName: Test
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author 行空XKong
 * @Create 2024/4/8 23:27
 * @Version 1.0
 */
public class Test {
    //逆序初始化
    private static void initOrder(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr.length - i;
        }
    }

    private static void notOrder(int[] arr) {
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(1_0000);
        }
    }

    private static void testInsert(int[] arr) {
        int[] tmpArr = Arrays.copyOf(arr, arr.length);
        long startTime = System.currentTimeMillis();
        Sort.insertSort(tmpArr);
        long endTime = System.currentTimeMillis();
        System.out.println("插入排序耗时：" + (endTime - startTime));
    }

    private static void testShellSort(int[] arr) {
        int[] tmpArr = Arrays.copyOf(arr, arr.length);
        long startTime = System.currentTimeMillis();
        Sort.shellSort(tmpArr);
        long endTime = System.currentTimeMillis();
        System.out.println("希尔排序耗时：" + (endTime - startTime));
    }

    private static void testSelectSort(int[] arr) {
        int[] tmpArr = Arrays.copyOf(arr, arr.length);
        long startTime = System.currentTimeMillis();
        Sort.selectSort(tmpArr);
        long endTime = System.currentTimeMillis();
        System.out.println("选择排序耗时：" + (endTime - startTime));
    }

    private static void testHeapSort(int[] arr) {
        int[] tmpArr = Arrays.copyOf(arr, arr.length);
        long startTime = System.currentTimeMillis();
        Sort.heapSort(tmpArr);
        long endTime = System.currentTimeMillis();
        System.out.println("堆排序耗时：" + (endTime - startTime));
    }

    private static void testBubbleSort(int[] arr) {
        int[] tmpArr = Arrays.copyOf(arr, arr.length);
        long startTime = System.currentTimeMillis();
        Sort.bubbleSort(tmpArr);
        long endTime = System.currentTimeMillis();
        System.out.println("冒泡排序耗时：" + (endTime - startTime));
    }

    public static void main1(String[] args) {
        int[] arr = {1,12,23,64,25,6};
//        Sort.insertSort(arr);
//        System.out.println(Arrays.toString(arr));
//        Sort.shellSort(arr);
//        System.out.println(Arrays.toString(arr));
//        Sort.selectSort(arr);
//        System.out.println(Arrays.toString(arr));
//        Sort.selectSort2(arr);
//        System.out.println(Arrays.toString(arr));
//        Sort.heapSort(arr);
//        System.out.println(Arrays.toString(arr));
        Sort.bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = new int[10_0000];
        initOrder(arr);
//        notOrder(arr);
        testInsert(arr);
        testSelectSort(arr);
        testShellSort(arr);
        testHeapSort(arr);
        testBubbleSort(arr);
    }
}
