import java.util.LinkedList;
import java.util.Queue;

/**
 * ClassName: BinaryTree
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author 行空XKong
 * @Create 2024/4/1 21:36
 * @Version 1.0
 */
public class BinaryTree {
    static class TreeNode {
        public char val;
        public TreeNode l;
        public TreeNode r;

        public TreeNode(char val) {
            this.val = val;
        }
    }

    public TreeNode createTree() {
        TreeNode A = new TreeNode('A');
        TreeNode B = new TreeNode('B');
        TreeNode C = new TreeNode('C');
        TreeNode D = new TreeNode('D');
        TreeNode E = new TreeNode('E');
        TreeNode F = new TreeNode('F');
        TreeNode G = new TreeNode('G');
        TreeNode H = new TreeNode('H');

        A.l = B;
        A.r = C;
        B.l = D;
        B.r = E;
        C.l = F;
        C.r = G;
        E.r = H;

        return A;
    }

    // 前序遍历
    void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.l);
        preOrder(root.r);
    }

    // 中序遍历
    void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.l);
        System.out.print(root.val + " ");
        inOrder(root.r);
    }

    // 后序遍历
    void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.l);
        postOrder(root.r);
        System.out.print(root.val + " ");
    }

    //获取节点数
    private int count;

    int size(TreeNode root) {
        if (root == null) {
            return 0;
        }
        ++count;
        size(root.l);
        size(root.r);
        return count;
    }

    //获取节点数2
    int size2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return size2(root.l) + size2(root.r) + 1;
    }

    //获取叶子节点的个数
    private int LeafCount;

    int getLeafNodeCount(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.l == null && root.r == null) {
            ++LeafCount;
        }
        getLeafNodeCount(root.l);
        getLeafNodeCount(root.r);
        return LeafCount;
    }

    //获取叶子节点的个数2
    int getLeafNodeCount2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.l == null && root.r == null) {
            return 1;
        }
        return getLeafNodeCount2(root.l) + getLeafNodeCount2(root.r);
    }

    //获取第K层节点的个数
    int getKLevelNodeCount(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        return getKLevelNodeCount(root.l, k - 1)
                + getKLevelNodeCount(root.r, k - 1);
    }

    //获取二叉树的高度
    int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.l);
        int rightHeight = getHeight(root.r);
        return (leftHeight > rightHeight) ? (leftHeight + 1) : (rightHeight + 1);
    }

    //获取二叉树的高度2
    int getHeight2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return (getHeight2(root.l) > getHeight2(root.r))
                ? (getHeight2(root.l) + 1) : (getHeight2(root.r) + 1);
    }

    //检测值为value的元素是否存在
    TreeNode find(TreeNode root, char val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        TreeNode retLeft = find(root.l, val);
        if (retLeft != null) {
            return retLeft;
        }
        TreeNode retRight = find(root.r, val);
        if (retRight != null) {
            return retRight;
        }
        return null;
    }

    //层序遍历
    void levelOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            System.out.print(tmp.val + " ");
            if (tmp.l != null) {
                queue.offer(tmp.l);
            }
            if (tmp.r != null) {
                queue.offer(tmp.r);
            }
        }
    }

    // 判断一棵树是不是完全二叉树
    boolean isCompleteTree(TreeNode root) {
        //连二叉树都不是当然不是完全二叉树
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        //将二叉树的节点存入队列
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur != null) {
                queue.offer(cur.l);
                queue.offer(cur.r);
            } else {
                break;
            }
        }
        //遍历队列剩下的元素
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            if (tmp != null) {
                return false;
            }
        }
        return true;
    }
}
