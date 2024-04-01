package test2;

import java.util.LinkedList;
import java.util.List;

/**
 * ClassName: Main
 * Package: test2
 * Description:94. 二叉树的中序遍历(递归实现)
 *
 * @Author 行空XKong
 * @Create 2024/4/1 23:12
 * @Version 1.0
 */
public class Main {
}

class Solution {
    // //方法一（不利用返回值）
    // List<Integer> ret = new LinkedList<>();
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     if (root == null) {
    //         return ret;
    //     }
    //     inorderTraversal(root.left);
    //     ret.add(root.val);
    //     inorderTraversal(root.right);
    //     return ret;
    // }
    //方法二（利用返回值）
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new LinkedList<>();
        if (root == null) {
            return ret;
        }
        List<Integer> leftTree = inorderTraversal(root.left);
        ret.addAll(leftTree);
        ret.add(root.val);
        List<Integer> rightTree = inorderTraversal(root.right);
        ret.addAll(rightTree);
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