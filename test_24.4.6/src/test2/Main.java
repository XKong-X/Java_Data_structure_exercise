package test2;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * ClassName: Main
 * Package: test2
 * Description:94. 二叉树的中序遍历(迭代实现)
 *
 * @Author 行空XKong
 * @Create 2024/4/6 10:28
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode top = stack.pop();
            list.add(top.val);
            root = top.right;
        }
        return list;
    }
}