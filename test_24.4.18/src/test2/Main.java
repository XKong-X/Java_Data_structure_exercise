package test2;

import java.util.*;

/**
 * ClassName: Main
 * Package: test2
 * Description:692. 前K个高频单词
 *
 * @Author 行空XKong
 * @Create 2024/4/18 22:12
 * @Version 1.0
 */
public class Main {
}

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        //统计单词出现次数,并存入map中
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (map.get(word) == null) {
                map.put(word, 1);
            } else {
                int val = map.get(word);
                map.put(word, val + 1);
            }
        }

        //遍历map，建立小根堆
        PriorityQueue<Map.Entry<String, Integer>> minHeap =
                new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                //当频率相同时，采用单词的字典序进行比较，以建立大根堆的方式比较
                if (o1.getValue().compareTo(o2.getValue()) == 0) {
                    return o2.getKey().compareTo(o1.getKey());
                }
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.offer(entry);
            } else {
                Map.Entry<String, Integer> top = minHeap.peek();
                if (entry.getValue().compareTo(top.getValue()) > 0) {
                    minHeap.poll();
                    minHeap.offer(entry);
                } else {
                    if (entry.getValue().compareTo(top.getValue()) == 0) {
                        if (entry.getKey().compareTo(top.getKey()) < 0) {
                            minHeap.poll();
                            minHeap.offer(entry);
                        }
                    }
                }
            }
        }

        //将堆中元素复制到List中
        List<String> ret = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ret.add(minHeap.poll().getKey());
        }
        //逆置
        Collections.reverse(ret);
        return ret;
    }
}