package test1;

import java.util.Stack;

/**
 * ClassName: Main
 * Package: test1
 * Description:150. 逆波兰表达式求值
 *
 * @Author 行空XKong
 * @Create 2024/3/27 21:00
 * @Version 1.0
 */
public class Main {
}

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String x : tokens) {
            if (!isOperation(x)) {
                stack.push(Integer.parseInt(x));
            } else {
                int num2 = stack.pop();
                int num1 = stack.pop();
                switch(x) {
                    case "+":
                        stack.push(num1 + num2);
                        break;
                    case "-":
                        stack.push(num1 - num2);
                        break;
                    case "*":
                        stack.push(num1 * num2);
                        break;
                    case "/":
                        stack.push(num1 / num2);
                        break;
                }
            }
        }
        return stack.pop();
    }

    private boolean isOperation(String s) {
        return s.equals("+") || s.equals("-")
                || s.equals("*") || s.equals("/");
    }
}
