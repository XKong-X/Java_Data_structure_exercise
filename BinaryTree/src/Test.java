/**
 * ClassName: Test
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author 行空XKong
 * @Create 2024/4/1 21:37
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        BinaryTree.TreeNode root = binaryTree.createTree();
        binaryTree.preOrder(root);
        System.out.println();
        binaryTree.inOrder(root);
        System.out.println();
        binaryTree.postOrder(root);
        System.out.println();
        System.out.println(binaryTree.getLeafNodeCount(root));
        System.out.println(binaryTree.getKLevelNodeCount(root, 3));
        System.out.println(binaryTree.getHeight(root));
        System.out.println(binaryTree.find(root, 'A'));
        binaryTree.levelOrder(root);
        System.out.println();
        System.out.println(binaryTree.isCompleteTree(root));
    }
}
