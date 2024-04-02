package test4;

/**
 * ClassName: Main
 * Package: test4
 * Description:226. 翻转二叉树
 *
 * @Author 行空XKong
 * @Create 2024/4/2 22:39
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
    public TreeNode invertTree(TreeNode root) {
        //判断是否为空
        if (root == null) {
            return null;
        }
        //判断是否有子节点
        if (root.left == null && root.right == null) {
            return root;//不能返回空，当只有一个节点的时候返回空是错误的
        }
        //交换
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
