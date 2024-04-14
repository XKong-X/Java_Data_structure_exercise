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

    private static void testQuickSort(int[] arr) {
        int[] tmpArr = Arrays.copyOf(arr, arr.length);
        long startTime = System.currentTimeMillis();
        Sort.quickSort(tmpArr);
        long endTime = System.currentTimeMillis();
        System.out.println("快速排序(递归)耗时：" + (endTime - startTime));
    }

    private static void testQuickSortIteration(int[] arr) {
        int[] tmpArr = Arrays.copyOf(arr, arr.length);
        long startTime = System.currentTimeMillis();
        Sort.quickSortIteration(tmpArr);
        long endTime = System.currentTimeMillis();
        System.out.println("快速排序(迭代)耗时：" + (endTime - startTime));
    }

    private static void testMergeSort(int[] arr) {
        int[] tmpArr = Arrays.copyOf(arr, arr.length);
        long startTime = System.currentTimeMillis();
        Sort.mergeSort(tmpArr);
        long endTime = System.currentTimeMillis();
        System.out.println("归并排序(递归)耗时：" + (endTime - startTime));
    }

    private static void testMergeSortIteration(int[] arr) {
        int[] tmpArr = Arrays.copyOf(arr, arr.length);
        long startTime = System.currentTimeMillis();
        Sort.mergeSortIteration(tmpArr);
        long endTime = System.currentTimeMillis();
        System.out.println("归并排序(迭代)耗时：" + (endTime - startTime));
    }

    private static void testCountSort(int[] arr) {
        int[] tmpArr = Arrays.copyOf(arr, arr.length);
        long startTime = System.currentTimeMillis();
        Sort.mergeSortIteration(tmpArr);
        long endTime = System.currentTimeMillis();
        System.out.println("计数排序耗时：" + (endTime - startTime));
    }

    public static void main1(String[] args) {
//        int[] arr = {1, 12, 23, 64, 25, 6};
        int[] arr = {100, 3, 15, 61, 17, 8, 55};
//        Sort.insertSort(arr);
//        Sort.shellSort(arr);
//        Sort.selectSort(arr);
//        Sort.selectSort2(arr);
//        Sort.heapSort(arr);
//        Sort.bubbleSort(arr);
//        Sort.quickSort(arr);
//        Sort.quickSortIteration(arr);
//        Sort.mergeSort(arr);
//        Sort.mergeSort(arr);
        Sort.countSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = new int[10_0000];
        initOrder(arr);
        notOrder(arr);
        testInsert(arr);
        testSelectSort(arr);
        testShellSort(arr);
        testHeapSort(arr);
//        testBubbleSort(arr);
        testQuickSort(arr);
        testQuickSortIteration(arr);
        testMergeSort(arr);
        testMergeSortIteration(arr);
        testCountSort(arr);
    }
}
