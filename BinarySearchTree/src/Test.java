import binarysearchtree.BinarySearchTree;

/**
 * ClassName: Test
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author 行空XKong
 * @Create 2024/4/16 21:02
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        int[] array = {5,12,3,2,11,15};
        for (int i = 0; i < array.length; i++) {
            binarySearchTree.insert(array[i]);
        }
        System.out.println(binarySearchTree.search(11));
        System.out.println(binarySearchTree.search(111));
        binarySearchTree.remove(12);
        System.out.println();
    }
}
