package test1;

import java.util.Stack;

/**
 * ClassName: Main
 * Package: test1
 * Description:20. 有效的括号
 *
 * @Author 行空XKong
 * @Create 2024/3/28 22:51
 * @Version 1.0
 */
public class Main {
}

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        //遍历
        for (int i = 0; i < s.length(); ++i) {
            char c1 = s.charAt(i);
            if (c1 == '(' || c1 == '[' || c1 == '{') {
                stack.push(c1);
            } else {//右括弧
                if (stack.empty()) {//不匹配
                    return false;
                }
                char c2 = stack.peek();
                if ((c2 == '(' && c1 == ')') || (c2 == '[' && c1 == ']')
                        || (c2 == '{' && c1 == '}')) {
                    stack.pop();
                } else {//不匹配
                    return false;
                }
            }
        }
        if (!stack.empty()) {//不匹配
            return false;
        }
        return true;
    }
}
