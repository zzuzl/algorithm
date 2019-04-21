package cn.zzuzl.structrue;

import cn.zzuzl.Base;
import cn.zzuzl.base.Node;
import cn.zzuzl.base.TreeNode;

public class BinarySearchTree extends Base {
    private TreeNode root;

    public BinarySearchTree(int val) {
        this.root = new TreeNode(val);
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree(10);
        tree.add(2);
        tree.add(12);
        tree.add(11);
        TreeNode node = tree.search(1);
        System.out.println(node);
        tree.prePrint();
    }

    public void add(int val) {
        if (root == null) {
            root = new TreeNode(val);
            return;
        }
        TreeNode node = root;
        while (node != null) {
            if (node.val == val) {
                return;
            } else if (val > node.val) {
                if (node.right == null) {
                    node.right = new TreeNode(val);
                    return;
                } else {
                    node = node.right;
                }
            } else {
                if (node.left == null) {
                    node.left = new TreeNode(val);
                    return;
                } else {
                    node = node.left;
                }
            }
        }
    }

    public void del(int val) {
        TreeNode node = root;
        TreeNode parent = null;

        while (node != null && node.val != val) {
            parent = node;
            if (node.val > val) {
                node = node.left;
            } else {
                node = node.right;
            }
        }

        if (node == null) {
            return;
        }

        // 要删除的节点有两个子节点
        if (node.left != null && node.right != null) {
            // 查找右子树的最小节点
            TreeNode min = node.right;
            TreeNode minP = node;
            while (min.left != null) {
                minP = min;
                min = min.left;
            }
            node.val = min.val;
            node = min;
            parent = minP;
        }

        // 删除节点是叶子节点或只有一个子节点
        TreeNode child = null;
        if (node.left == null) {
            child = node.right;
        } else if (node.right == null) {
            child = node.left;
        }

        // 要删除的是根节点
        if (parent == null) {
            root = child;
        } else if (parent.left == node) { // 只有一个节点或叶子结点
            parent.left = child;
        } else {  // 只有一个节点或叶子结点
            parent.right = child;
        }
    }

    public TreeNode search(int val) {
        TreeNode p = root;
        while (p != null) {
            if (p.val == val) {
                return p;
            } else if (p.val < val) {
                p = p.right;
            } else {
                p = p.left;
            }
        }

        return null;
    }

    public void prePrint() {
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<TreeNode>(10);
        stack.push(node);

        while ((node = stack.pop()) != null) {
            System.out.println(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }
}
