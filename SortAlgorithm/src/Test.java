import java.util.Arrays;

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
    public static void main(String[] args) {
        int[] arr = {1,12,23,64,25,6};
//        Sort.insertSort(arr);
//        System.out.println(Arrays.toString(arr));
        Sort.shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
