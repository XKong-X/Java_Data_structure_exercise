package test1;

/**
 * ClassName: Main
 * Package: test1
 * Description:JZ36 二叉搜索树与双向链表
 *
 * @Author 行空XKong
 * @Create 2024/4/18 21:00
 * @Version 1.0
 */
public class Main {
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

class Solution {
    private TreeNode head = null;//用来记录搜索树最左边的节点（即双向链表的头节点）
    private TreeNode prev = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return pRootOfTree;
        }
        Convert(pRootOfTree.left);
        if (prev == null) {
            prev = pRootOfTree;
            head = pRootOfTree;
        } else {
            prev.right = pRootOfTree;
            pRootOfTree.left = prev;
            prev = pRootOfTree;//更新prev
        }
        Convert(pRootOfTree.right);
        return head;
    }
}