/**
 * ClassName: Test
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author 行空XKong
 * @Create 2024/4/6 18:57
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        TestHeap testHeap = new TestHeap();
        int[] arr = {27,15,19,18,28,34,65,49,25,37};
        //int[] test = {1};//用于测试是否能正确抛异常
        testHeap.initElem(arr);

        testHeap.createHeap();

        testHeap.heapSort();

        testHeap.pop();
    }
}
