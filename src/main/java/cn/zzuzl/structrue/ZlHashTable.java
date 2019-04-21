package cn.zzuzl.structrue;

import cn.zzuzl.base.Node;

public class ZlHashTable {
    private Node[] data;
    private int size = 16;

    public ZlHashTable() {
        this.data = new Node[size];
    }

    int hash(int val) {
        return Math.abs(val) % 16;
    }

    void push(int val) {
        Node node = data[hash(val)];
        if (node == null) {
            node = new Node(val);
        } else {
            Node p = node;
            while (p.next != null) {
                if (p.val == val) {
                    return;
                }
                p = p.next;
            }
            p.next = new Node(val);
        }
    }

    boolean exist(int val) {
        Node node = data[hash(val)];
        if (node == null) {
            return false;
        } else {
            Node p = node;
            while (p.next != null) {
                if (p.val == val) {
                    return true;
                }
                p = p.next;
            }
            return false;
        }
    }


}
