package test4;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Main
 * Package: test4
 * Description:118. 杨辉三角
 *
 * @Author 行空XKong
 * @Create 2024/3/17 0:41
 * @Version 1.0
 */
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; ++i) {//控制行数
            List<Integer> rowNum = new ArrayList<Integer>();
            for (int j = 0; j <= i; ++j) {//生成每行的数
                if (j == 0 || i == j) {
                    rowNum.add(1);
                } else {
                    rowNum.add(ret.get(i - 1).get(j - 1) + ret.get(i - 1).get(j));
                }
            }
            ret.add(rowNum);
        }
        return ret;
    }
}

public class Main {
    public static void main(String[] args) {
        List<List<Integer>> ret = new Solution().generate(5);
        ret.toArray();
        System.out.println(ret);
    }
}
