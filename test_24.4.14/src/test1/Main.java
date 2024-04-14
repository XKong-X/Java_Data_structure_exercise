package test1;

/**
 * ClassName: Main
 * Package: test1
 * Description:912. 排序数组
 *
 * @Author 行空XKong
 * @Create 2024/4/14 15:16
 * @Version 1.0
 */
public class Main {
}

class Solution {
    public int[] sortArray(int[] arr) {
        int minVal = 0;
        int maxVal = 0;
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] < minVal) {
                minVal = arr[i];
            }
            if (arr[i] > maxVal) {
                maxVal = arr[i];
            }
        }

        //确定计数数组的长度并创建数组
        int len = maxVal - minVal + 1;
        int[] count = new int[len];

        //把数据的出现次数存入计数数组 O(n)
        for (int i = 0; i < arr.length; ++i) {
//            if (arr[i] == i + minVal) {
//                ++count[i];
//            }
            count[arr[i] - minVal]++;
        }

        //通过计数数组把数据写回原数组
        int arrIndex = 0;
        for (int i = 0; i < count.length; ++i) {
            //清除count中一格的数据
            while (count[i] > 0) {
                arr[arrIndex++] = i + minVal;
                --count[i];
            }
        }
        return arr;
    }
}