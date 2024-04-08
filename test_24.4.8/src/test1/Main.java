package test1;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * ClassName: Main
 * Package: test1
 * Description:面试题 17.14. 最小K个数
 *
 * @Author 行空XKong
 * @Create 2024/4/8 22:35
 * @Version 1.0
 */
public class Main {
}

class Imp implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2.compareTo(o1);
    }
}

class Solution {
    public int[] smallestK(int[] arr, int k) {
        int[] ret = new int[k];
        if (arr == null || k <= 0) {
            return ret;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Imp());
        //以大根堆形式存入k个数据
        for (int i = 0; i < k; ++i) {
            priorityQueue.offer(arr[i]);
        }
        //调整堆中数据
        for (int i = k; i < arr.length; ++i) {
            if (arr[i] < priorityQueue.peek()) {
                priorityQueue.poll();
                priorityQueue.offer(arr[i]);
            }
        }
        //用新数组接收并返回
        for (int i = 0; i < k; ++i) {
            ret[i] = priorityQueue.poll();
        }
        return ret;
    }
}