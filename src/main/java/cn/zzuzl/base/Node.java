package cn.zzuzl.base;

import cn.zzuzl.structrue.Stack;

import java.util.LinkedList;

public class Node {
    public int val;
    public Node next;

    public Node(int val) {
        this.val = val;
    }

    // 将两个有序链表合并成一个无重复的有序链表
    public static Node merge(Node node1, Node node2) {
        Node n = null;
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }

        if (node1.val < node2.val) {
            n = node1;
            Node merge = merge(node1.next, node2);
            if (merge.val == n.val) {
                n.next = merge.next;
            } else {
                n.next = merge;
            }
        } else {
            n = node2;
            Node merge = merge(node2.next, node1);
            if (merge.val == n.val) {
                n.next = merge.next;
            } else {
                n.next = merge;
            }
        }
        return n;
    }

}
