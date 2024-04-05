package test2;

/**
 * ClassName: Main
 * Package: test2
 * Description:105. 从前序与中序遍历序列构造二叉树
 *
 * @Author 行空XKong
 * @Create 2024/4/5 22:53
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
    public int preIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeChild(preorder, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeChild(int[] preorder, int[] inorder,
                                    int ibegin, int iend) {
        if (ibegin > iend) {
            //没左树或没右树
            return null;
        }
        TreeNode root = new TreeNode(preorder[preIndex]);
        //寻找中序遍历数组的根的位置
        int inorderRootIndex = findInorderRootIndex(inorder,
                ibegin, iend, preorder[preIndex]);
        if (inorderRootIndex == -1) {
            return null;
        }
        ++preIndex;
        root.left = buildTreeChild(preorder, inorder,
                ibegin, inorderRootIndex - 1);
        root.right = buildTreeChild(preorder, inorder,
                inorderRootIndex + 1, iend);
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