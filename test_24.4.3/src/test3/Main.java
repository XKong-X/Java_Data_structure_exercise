package test3;

import java.util.Scanner;

/**
 * ClassName: Main
 * Package: test3
 * Description:KY11 二叉树遍历
 *
 * @Author 行空XKong
 * @Create 2024/4/4 0:26
 * @Version 1.0
 */
//树的结点
class TreeNode {
    public char val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(char val) {
        this.val = val;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String str = in.nextLine();
            TreeNode root = createTree(str);
            inorder(root);
        }
    }

    //生成二叉树
    public static int i;

    public static TreeNode createTree(String str) {
        TreeNode root = null;
        char ch = str.charAt(i);
        if (ch != '#') {
            root = new TreeNode(ch);
            ++i;
            root.left = createTree(str);
            root.right = createTree(str);
        } else {
            ++i;
        }
        //返回
        return root;
    }

    //中序遍历
    public static void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }
}