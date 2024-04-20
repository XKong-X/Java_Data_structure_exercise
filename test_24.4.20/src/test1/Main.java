package test1;

import java.util.*;

/**
 * ClassName: Main
 * Package: test1
 * Description:NC228 判断子序列
 *
 * @Author 行空XKong
 * @Create 2024/4/20 0:17
 * @Version 1.0
 */
public class Main {
}

class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param S string字符串
     * @param T string字符串
     * @return bool布尔型
     */
    public boolean isSubsequence(String S, String T) {
        int i = 0;
        int j = 0;
        while (i < S.length() && j < T.length()) {
            char ch1 = S.charAt(i);
            char ch2 = T.charAt(j);
            if (ch1 == ch2) {
                ++i;
                ++j;
            } else {
                ++j;
            }
        }
        //S走完意味着符合条件
        // if (i >= S.length()) {
        //     return true;
        // }
        // return false;
        return i >= S.length();
    }
}