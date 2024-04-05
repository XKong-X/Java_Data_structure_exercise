package test1;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * ClassName: Main
 * Package: test1
 * Description:144. 二叉树的前序遍历(迭代实现)
 *
 * @Author 行空XKong
 * @Create 2024/4/6 2:15
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        //栈为空说明树已经遍历完了
        while (!stack.isEmpty() || root != null) {
            //模拟前序遍历
            while (root != null) {
                stack.push(root);
                list.add(root.val);
                root = root.left;
            }
            TreeNode top = stack.pop();
            root = top.right;
        }
        return list;
    }
}