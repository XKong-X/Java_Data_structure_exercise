package test3;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * ClassName: Main
 * Package: test3
 * Description:145. 二叉树的后序遍历(迭代实现)
 *
 * @Author 行空XKong
 * @Create 2024/4/6 11:25
 * @Version 1.0
 */
public class Main {
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;//记录上一个被打印的结点
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode top = stack.peek();
            if (top.right == null || prev == top.right) {
                list.add(top.val);
                stack.pop();
                prev = top;
            } else {
                root = top.right;
            }
        }
        return list;
    }
}