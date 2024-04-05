package test4;

/**
 * ClassName: Main
 * Package: test4
 * Description:606. 根据二叉树创建字符串
 *
 * @Author 行空XKong
 * @Create 2024/4/6 1:40
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
    public String tree2str(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        tree2StrChild(root, stringBuilder);
        return stringBuilder.toString();
    }

    public void tree2StrChild(TreeNode root, StringBuilder stringBuilder) {
        if (root == null) {
            return;
        }
        stringBuilder.append(root.val);
        //判断左树
        if (root.left != null) {
            stringBuilder.append('(');
            tree2StrChild(root.left, stringBuilder);
            stringBuilder.append(')');
        } else {//root.left == null
            if (root.right == null) {
                return;
            } else {//root.right != null
                stringBuilder.append("()");
            }
        }

        //判断右树
        if (root.right != null) {
            stringBuilder.append('(');
            tree2StrChild(root.right, stringBuilder);
            stringBuilder.append(')');
        }
    }
}