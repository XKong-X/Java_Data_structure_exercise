package test2;

/**
 * ClassName: Main
 * Package: test2
 * Description:100. 相同的树
 *
 * @Author 行空XKong
 * @Create 2024/4/2 21:25
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