package test2;

import java.util.Scanner;
import java.util.Stack;

/**
 * ClassName: Main
 * Package: test2
 * Description:AB5 点击消除
 *
 * @Author 行空XKong
 * @Create 2024/4/21 0:16
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String str = in.nextLine();
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < str.length(); ++i) {
                char ch = str.charAt(i);
                if (stack.empty() || stack.peek() != ch) {
                    stack.push(ch);
                } else {
                    stack.pop();
                }
            }
            if (stack.empty()) {
                System.out.print("0");
            } else {
                Stack<Character> stack2 = new Stack<>();
                while (!stack.empty()) {
                    stack2.push(stack.pop());
                }
                while (!stack2.empty()) {
                    System.out.print(stack2.pop());
                }
            }
        }
    }
}
