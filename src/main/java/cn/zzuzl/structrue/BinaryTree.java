package cn.zzuzl.structrue;

import cn.zzuzl.base.TreeNode;

import java.util.*;
import java.util.Stack;

// 二叉树
public class BinaryTree {
    private TreeNode root;
    private int last;
    private boolean isFirst = true;

    public BinaryTree(int val) {
        root = new TreeNode(val);
    }

    // 前序遍历 栈  非递归
    void preTraversal() {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.println(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    // 按层遍历 队列
    void ccTraversal() {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.println(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    // 翻转二叉树
    void invertTree(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        if (root.left != null) {
            invertTree(root.left);
        }
        if (root.right != null) {
            invertTree(root.right);
        }
    }

    // 求二叉树最大深度 队列
    int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0;i<size;i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            depth++;
        }
        return depth;
    }

    // 求二叉树深度 递归
    int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth2(root.left) + 1, maxDepth2(root.right) + 1);
    }

    // 是否为有效的二叉搜索树
    boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (isValidBST(root.left)) {
            if (isFirst || last < root.val) {
                isFirst = false;
                last = root.val;
                return isValidBST(root.right);
            }
        }

        return false;
    }

    // 根据前序遍历和中序遍历还原二叉树
    TreeNode treeFromOrder(String pre, String in, int len) {
        if (len <= 0) {
            return null;
        }
        TreeNode root = new TreeNode(pre.charAt(0) - '0');
        int count = in.indexOf(pre.charAt(0));
        String pl = pre.substring(1, count);
        String il = in.substring(0, count);

        int count2 = in.length() - count - 1;
        String pr = pre.substring(1+count);
        String ir = in.substring(count + 1);
        root.left = treeFromOrder(pl, il, count);
        root.right = treeFromOrder(pr, ir, count2);
        return root;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(1);
        TreeNode root = tree.root;
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        // tree.preTraversal();

        // tree.ccTraversal();
        // tree.invertTree(tree.root);
        // tree.ccTraversal();
        // System.out.println(tree.maxDepth(tree.root));
        System.out.println(tree.maxDepth2(tree.root));
    }
}
