package test1;

/**
 * ClassName: Main
 * Package: test1
 * Description:104. 二叉树的最大深度
 *
 * @Author 行空XKong
 * @Create 2024/4/2 20:58
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
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        return (leftHeight > rightHeight) ? (leftHeight + 1) : (rightHeight + 1);
    }
}
