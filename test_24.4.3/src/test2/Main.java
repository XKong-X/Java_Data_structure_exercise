package test2;

/**
 * ClassName: Main
 * Package: test2
 * Description:110. 平衡二叉树
 *
 * @Author 行空XKong
 * @Create 2024/4/3 21:46
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
    // //方法一
    // public boolean isBalanced(TreeNode root) {
    //     if (root == null) {
    //         return true;
    //     }
    //     if (Math.abs(maxDepth(root.left) - maxDepth(root.right)) > 1) {
    //         return false;
    //     }
    //     //有假则返回假
    //     if (!isBalanced(root.left) || !isBalanced(root.right)) {
    //         return false;
    //     }
    //     return true;
    // }

    // //方法二
    // public boolean isBalanced(TreeNode root) {
    //     if (root == null) {
    //         return true;
    //     }
    //     //左右子树相差小于等于1且左子树和右子树都返回真时，才返回真
    //     return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1
    //     && isBalanced(root.left) && isBalanced(root.right);
    // }

    // //求深度
    // public int maxDepth(TreeNode root) {
    //     if (root == null) {
    //         return 0;
    //     }
    //     int leftHeight = maxDepth(root.left);
    //     int rightHeight = maxDepth(root.right);
    //     return (leftHeight > rightHeight) ? (leftHeight + 1) : (rightHeight + 1);
    // }

    //方法三
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return maxDepth2(root) >= 0;
    }

    //求深度2
    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = maxDepth2(root.left);
        if (leftHeight < 0) {
            return -1;
        }
        int rightHeight = maxDepth2(root.right);
        if (rightHeight < 0) {
            return -1;
        }
        if (Math.abs(leftHeight - rightHeight) <= 1) {
            return Math.max(leftHeight, rightHeight) + 1;
        } else {
            return -1;
        }
    }
}