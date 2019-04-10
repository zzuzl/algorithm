package cn.zzuzl.structrue;

import cn.zzuzl.base.Node;

/**
 * 链表实现LRU
 */
public class LinkList {
    public Node head;
    private int len;
    public int max;

    public LinkList(int[] vals, int max) {
        if (vals.length > max) {
            throw new RuntimeException();
        }
        head = new Node(vals[0]);
        Node n = head;
        len = 1;
        for (int i=1;i<vals.length;i++) {
            n.next = new Node(vals[i]);
            n = n.next;
            len ++;
        }

        this.max = max;
    }

    public static void main(String[] args) {
        LinkList linkList = new LinkList(new int[]{1, 2}, 3);
        linkList.print();
        linkList.add(3);
        linkList.print();
        linkList.add(4);
        linkList.print();
        linkList.add(1);
        linkList.print();
    }

    public void add(int value) {
        if (head == null) {
            head = new Node(value);
            len = 1;
            return;
        }

        Node temp = head;
        Node pre = null;

        boolean find = false;
        while (temp.next != null) {
            if (temp.val == value) {
                find = true;
                if (pre != null) {
                    Node node = new Node(value);
                    pre.next = temp.next;
                    node.next = head;
                    head = node;
                }

                break;
            }

            pre = temp;
            temp = temp.next;
        }
        if (!find) {
            Node node = new Node(value);
            node.next = head;
            head = node;
            if (len >= max) {
                temp = head;
                pre = null;
                while (temp.next != null) {
                    pre = temp;
                    temp = temp.next;
                }
                pre.next = null;
            } else {
                len ++;
            }
        }
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        Node temp = head;
        while (temp != null) {
            sb.append(temp.val).append("->");
            temp = temp.next;
        }
        System.out.println(sb.toString() + "   长度：" + len);
    }

}
