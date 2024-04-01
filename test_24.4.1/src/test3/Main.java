package test3;

import java.util.LinkedList;
import java.util.List;

/**
 * ClassName: Main
 * Package: test3
 * Description:145. 二叉树的后序遍历(递归实现)
 *
 * @Author 行空XKong
 * @Create 2024/4/1 23:16
 * @Version 1.0
 */
public class Main {
}

class Solution {
    // //方法一（不利用返回值）
    // List<Integer> ret = new LinkedList<>();
    // public List<Integer> postorderTraversal(TreeNode root) {
    //     if (root == null) {
    //         return ret;
    //     }
    //     postorderTraversal(root.left);
    //     postorderTraversal(root.right);
    //     ret.add(root.val);
    //     return ret;
    // }
    //方法二（利用返回值）
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new LinkedList<>();
        if (root == null) {
            return ret;
        }
        List<Integer> leftTree = postorderTraversal(root.left);
        ret.addAll(leftTree);
        List<Integer> rightTree = postorderTraversal(root.right);
        ret.addAll(rightTree);
        ret.add(root.val);
        return ret;
    }
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