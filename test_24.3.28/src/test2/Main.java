package test2;

import java.util.Stack;

/**
 * ClassName: Main
 * Package: test2
 * Description:JZ31 栈的压入、弹出序列
 *
 * @Author 行空XKong
 * @Create 2024/3/28 23:12
 * @Version 1.0
 */
public class Main {
}

class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param pushV int整型一维数组
     * @param popV  int整型一维数组
     * @return bool布尔型
     */
    public boolean IsPopOrder(int[] pushV, int[] popV) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0; i < pushV.length; ++i) {
            stack.push(pushV[i]);
            while (!stack.empty() && j < popV.length
                    && stack.peek() == popV[j]) {//配对，成功则pop
                stack.pop();
                ++j;
            }
        }
        return stack.empty();//为空返回true，否则返回false
    }
}