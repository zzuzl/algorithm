package cn.zzuzl.structrue;

import cn.zzuzl.base.Node;

// 单向链表
public class SingleLinkNode {
    private Node head;

    public SingleLinkNode(int val) {
        head = new Node(val);
    }

    public void add(int val) {
        Node p = head;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new Node(val);
    }

    public void delete(int val) {
        Node p = head;
        Node pre = null;

        while (p != null) {
            if (p.val == val) {
                if (pre == null) {
                    head = p.next;
                } else {
                    pre.next = p.next;
                }
            } else {
                pre = p;
            }

            p = p.next;
        }
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        Node p = head;
        while (p != null) {
            sb.append(p.val).append("->");
            p = p.next;
        }
        System.out.println(sb.toString());
    }

    public void reverse() {
        Node p = head;
        Node p2 = p.next,p3 = null;

        if (p2 == null) {
            return;
        }
        p3 = p2.next;

        while (p2 != null) {
            p2.next = p;
            if (p == head) {
                p.next = null;
            }
            if (p3 == null) {
                head = p2;
                return;
            }

            p = p2;
            p2 = p3;
            p3 = p3.next;
        }
    }

    public int getMiddleVal() {
        Node p = head, p2 = head;
        while (p2 != null && p2.next != null) {
            p = p.next;
            p2 = p2.next.next;
        }
        return p.val;

    }

    public static void main(String[] args) {
        SingleLinkNode linkNode = new SingleLinkNode(1);
        linkNode.add(2);
        linkNode.add(3);
        linkNode.add(3);
        linkNode.add(5);
        // linkNode.delete(2);
        linkNode.print();
        // linkNode.reverse();
        // linkNode.print();
        // System.out.println(linkNode.getMiddleVal());

        SingleLinkNode linkNode2 = new SingleLinkNode(2);
        linkNode2.add(2);
        linkNode2.add(4);
        linkNode2.add(4);
        linkNode2.add(4);
        linkNode2.print();

        Node node = Node.merge(linkNode.head, linkNode2.head);
        System.out.println(node.val);
    }
}
