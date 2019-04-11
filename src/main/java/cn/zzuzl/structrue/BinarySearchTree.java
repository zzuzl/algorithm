package cn.zzuzl.structrue;

import cn.zzuzl.Base;
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
        TreeNode node = root;
        while (node != null) {
            if (node.val == val) {
                throw new RuntimeException();
            }
            if (val > node.val) {
                if (node.right == null) {
                    node.right = new TreeNode(val);
                    break;
                } else {
                    node = node.right;
                }
            } else {
                if (node.left == null) {
                    node.left = new TreeNode(val);
                    break;
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

        if (node == null || parent == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            parent.left = null;
        } else if (node.left == null) {
            parent.left = node.right;
        } else if (node.right == null) {
            parent.right = node.left;
        } else {
            TreeNode minP = node.right;
            TreeNode minPP = node;
            while (minP.left != null) {
                minPP = minP;
                minP = minP.left;
            }
            node.val = minP.val;
            minPP.left = null;
        }
    }

    public TreeNode search(int val) {
        return searchCore(root, val);
    }

    private TreeNode searchCore(TreeNode node, int val) {
        if (node == null) {
            return null;
        }
        if (node.val == val) {
            return node;
        }
        if (val > node.val) {
            return searchCore(node.right, val);
        } else {
            return searchCore(node.left, val);
        }
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
