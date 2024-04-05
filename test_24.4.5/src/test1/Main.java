package test1;

/**
 * ClassName: Main
 * Package: test1
 * Description:236. 二叉树的最近公共祖先
 *
 * @Author 行空XKong
 * @Create 2024/4/5 18:41
 * @Version 1.0
 */
public class Main {
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    //方法一
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode leftTree = lowestCommonAncestor(root.left, p, q);
        TreeNode rightTree = lowestCommonAncestor(root.right, p, q);
        if (leftTree != null && rightTree != null) {
            return root;
        } else if (leftTree != null) {
            return leftTree;
        } else {
            return rightTree;
        }
    }

    // //方法二
    // public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    //     if (root == null) {
    //         return null;
    //     }
    //     //创建栈
    //     Stack<TreeNode> stackP = new Stack<>();
    //     Stack<TreeNode> stackQ = new Stack<>();
    //     //获取路径并保存在栈中
    //     getPath(root, p, stackP);
    //     getPath(root, q, stackQ);
    //     //获取栈的大小
    //     int sizeP = stackP.size();
    //     int sizeQ = stackQ.size();
    //     //对齐
    //     if (sizeP > sizeQ) {
    //         int size = sizeP - sizeQ;
    //         while (size != 0) {
    //             stackP.pop();
    //             --size;
    //         }
    //     } else {
    //         int size = sizeQ - sizeP;
    //         while (size != 0) {
    //             stackQ.pop();
    //             --size;
    //         }
    //     }
    //     //对比栈中数据
    //     while (!stackP.isEmpty() && !stackQ.isEmpty()) {
    //         if (stackP.peek() == stackQ.peek()) {
    //             return stackP.peek();//返回stackQ.peek()也行
    //         }
    //         stackP.pop();
    //         stackQ.pop();
    //     }
    //     return null;
    // }

    // private boolean getPath(TreeNode root, TreeNode node, Stack<TreeNode> stack) {
    //     if (root == null) {
    //         return false;
    //     }
    //     stack.push(root);
    //     if (root == node) {
    //         return true;
    //     }
    //     boolean flagLeft = getPath(root.left, node, stack);
    //     if (flagLeft) {
    //         return true;
    //     }
    //     boolean flagRight = getPath(root.right, node, stack);
    //     if (flagRight) {
    //         return true;
    //     }
    //     stack.pop();
    //     return false;
    // }
}