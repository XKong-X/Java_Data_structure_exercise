package binarysearchtree;

/**
 * ClassName: BinarySearchTree
 * Package: binarysearchtree
 * Description:二叉搜索树
 *
 * @Author 行空XKong
 * @Create 2024/4/16 21:03
 * @Version 1.0
 */
public class BinarySearchTree {
    static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode root;

    /**
     * 时间复杂度：最好情况（完全二叉树）：O(log₂n),最坏情况（单分支的树）：O(n)
     * @param key
     * @return
     */
    public boolean search(int key) {
        TreeNode tmp = root;
        while (tmp != null) {
            if (tmp.val < key) {
                tmp = tmp.right;
            } else if (tmp.val > key) {
                tmp = tmp.left;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean insert(int val) {
        TreeNode node = new TreeNode(val);
        if (root == null) {
            root = node;
            return true;
        }

        TreeNode parent = null;
        TreeNode tmp = root;
        while (tmp != null) {
            if (tmp.val < val) {
                parent = tmp;
                tmp = tmp.right;
            } else if (tmp.val > val) {
                parent = tmp;
                tmp = tmp.left;
            } else {
                return false;
            }
        }

        //代码走到这不存在相等的数据，不用判断==
        if (parent.val < val) {
            parent.right = node;
        } else {
            parent.left = node;
        }
        return true;
    }

    public void remove(int key) {
        TreeNode parent = null;
        TreeNode tmp = root;
        while (tmp != null) {
            if (tmp.val < key) {
                parent = tmp;
                tmp = tmp.right;
            } else if (tmp.val > key) {
                parent = tmp;
                tmp = tmp.left;
            } else {
                //删除
                removeNode(tmp, parent);
            }
        }
    }

    private void removeNode(TreeNode tmp, TreeNode parent) {
        if (tmp.left == null) {
            if (tmp == root) {
                tmp = tmp.right;
            } else if (tmp == parent.left) {
                parent.left = tmp.right;
            } else {//tmp == parent.right
                parent.right = tmp.right;
            }

        } else if (tmp.right == null) {
            if (tmp == root) {
                tmp = tmp.left;
            } else if (tmp == parent.left) {
                parent.left = tmp.left;
            } else {//tmp == parent.right
                parent.right = tmp.left;
            }
        } else {
            //找右树最左边的值
            TreeNode targetParent = tmp;
            TreeNode target = tmp.right;
            while (target.left != null) {
                targetParent = target;
                target = target.left;
            }

            tmp.val = target.val;

            //删除target节点
            if (targetParent.left == target) {
                /**
                 * target已经是最左边的数据了
                 * target.left必定为null
                 * 因此把target.right给到targetParent.left
                 */
                targetParent.left = target.right;
            } else {
                targetParent.right = target.right;
            }
        }
    }
}
