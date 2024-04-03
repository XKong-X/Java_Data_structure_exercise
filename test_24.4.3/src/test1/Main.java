package test1;

/**
 * ClassName: Main
 * Package: test1
 * Description:101. 对称二叉树
 *
 * @Author 行空XKong
 * @Create 2024/4/3 20:15
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
    // public boolean isSymmetric(TreeNode root) {
    //     invertTree(root.left);//翻转左子树（翻转一边即可）
    //     return isSameTree(root.left, root.right);//对比
    // }

    // //对比是否相同
    // public boolean isSameTree(TreeNode p, TreeNode q) {
    //     if (p == null && q!= null || p != null && q == null) {
    //         return false;
    //     }
    //     if (p == null && q == null) {
    //         //说明该分支相同
    //         return true;
    //     }
    //     //p != null && q!= null
    //     if (p.val != q.val) {
    //         return false;
    //     }
    //     //该分支暂时相同，继续往里递
    //     return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    // }

    // //翻转
    // public TreeNode invertTree(TreeNode root) {
    //     //判断是否为空
    //     if (root == null) {
    //         return null;
    //     }
    //     //判断是否有子节点
    //     if (root.left == null && root.right == null) {
    //         return root;//不能返回空，当只有一个节点的时候返回空是错误的
    //     }
    //     //交换
    //     TreeNode tmp = root.left;
    //     root.left = root.right;
    //     root.right = tmp;
    //     invertTree(root.left);
    //     invertTree(root.right);
    //     return root;
    // }
    //方法二
    public boolean isSymmetric(TreeNode root) {
        return isSymmetricChild(root.left, root.right);
    }

    //对比
    private boolean isSymmetricChild(TreeNode leftTree, TreeNode rightTree) {
        if (leftTree == null && rightTree != null
                || leftTree != null && rightTree == null) {
            return false;
        }
        if (leftTree == null && rightTree == null) {
            return true;
        }
        if (leftTree.val != rightTree.val) {
            return false;
        }
        return isSymmetricChild(leftTree.left, rightTree.right)
                && isSymmetricChild(leftTree.right, rightTree.left);
    }
}