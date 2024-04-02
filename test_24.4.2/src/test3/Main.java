package test3;

/**
 * ClassName: Main
 * Package: test3
 * Description:572. 另一棵树的子树
 *
 * @Author 行空XKong
 * @Create 2024/4/2 22:21
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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        //递到空了都没返回值说明不相等
        if (root == null) {
            return false;
        }
        //判断根
        if (isSameTree(root, subRoot)) {
            return true;
        }
        //判断左子树
        if (isSubtree(root.left, subRoot)) {
            return true;
        }
        //判断右子树
        if (isSubtree(root.right, subRoot)) {
            return true;
        }
        return false;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q != null || p != null && q == null) {
            return false;
        }
        if (p == null && q == null) {
            //说明该分支相同
            return true;
        }
        //p != null && q!= null
        if (p.val != q.val) {
            return false;
        }
        //该分支暂时相同，继续往里递
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}