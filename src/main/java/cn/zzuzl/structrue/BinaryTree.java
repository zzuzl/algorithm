package cn.zzuzl.structrue;

import cn.zzuzl.base.TreeNode;

import java.util.*;
import java.util.Stack;

// 二叉树
public class BinaryTree {
    private TreeNode root;

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

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(1);
        TreeNode root = tree.root;
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        // tree.preTraversal();

        tree.ccTraversal();
    }
}
