package cn.zzuzl.structrue;

import cn.zzuzl.base.DoubleNode;

// 双向链表
public class DoubleLinkNode {
    private DoubleNode head;

    public DoubleLinkNode(int val) {
        head = new DoubleNode(val);
    }

    public void add(int val) {
        DoubleNode p = head;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new DoubleNode(val);
        p.next.pre = p;
    }

    public void delete(int val) {
        DoubleNode p = head;

        while (p != null) {
            if (p.val == val) {
                if (p == head) {
                    head = p.next;
                    head.pre = null;
                } else {
                    p.pre.next = p.next;
                    p.next.pre = p.pre;
                }
            }

            p = p.next;
        }
    }

}
