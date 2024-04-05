package test3;

/**
 * ClassName: Main
 * Package: test3
 * Description:106. 从中序与后序遍历序列构造二叉树
 *
 * @Author 行空XKong
 * @Create 2024/4/5 23:06
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
    private int postIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length - 1;
        return buildTreeChild(postorder, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeChild(int[] postorder, int[] inorder,
                                    int ibegin, int iend) {
        if (ibegin > iend) {
            //没左树或没右树
            return null;
        }
        TreeNode root = new TreeNode(postorder[postIndex]);
        //寻找中序遍历数组的根的位置
        int inorderRootIndex = findInorderRootIndex(inorder,
                ibegin, iend, postorder[postIndex]);
        if (inorderRootIndex == -1) {
            return null;
        }
        --postIndex;
        root.right = buildTreeChild(postorder, inorder,
                inorderRootIndex + 1, iend);
        root.left = buildTreeChild(postorder, inorder,
                ibegin, inorderRootIndex - 1);
        return root;
    }

    private int findInorderRootIndex(int[] inorder, int ibegin,
                                     int iend, int val) {
        for (int i = ibegin; i <= iend; ++i) {
            if (inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }
}