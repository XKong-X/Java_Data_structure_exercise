package test1;

import java.util.LinkedList;
import java.util.List;

/**
 * ClassName: Main
 * Package: test1
 * Description:144. 二叉树的前序遍历(递归实现)
 *
 * @Author 行空XKong
 * @Create 2024/4/1 23:07
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
    // //方法一（不利用返回值）
    // List<Integer> ret = new LinkedList<>();
    // public List<Integer> preorderTraversal(TreeNode root) {
    //     if (root == null) {
    //         return ret;
    //     }
    //     ret.add(root.val);
    //     preorderTraversal(root.left);
    //     preorderTraversal(root.right);
    //     return ret;
    // }
    //方法二（利用返回值）
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new LinkedList<>();
        if (root == null) {
            return ret;
        }
        ret.add(root.val);
        List<Integer> leftTree = preorderTraversal(root.left);
        ret.addAll(leftTree);
        List<Integer> rightTree = preorderTraversal(root.right);
        ret.addAll(rightTree);
        return ret;
    }
}