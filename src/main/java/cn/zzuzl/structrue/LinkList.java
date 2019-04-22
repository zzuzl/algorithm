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
        /*LinkList linkList = new LinkList(new int[]{1, 2}, 3);
        linkList.print();
        linkList.add(3);
        linkList.print();
        linkList.add(4);
        linkList.print();
        linkList.add(1);
        linkList.print();*/

        int[] a = new int[]{1, 3, 5, 6};
        int[] b = new int[]{2, 4, 5, 5};

        Node node1 = null, node2 = null;
        Node root1 = null, root2 = null;
        for (int i : a) {
            if (node1 == null) {
                node1 = new Node(i);
                root1 = node1;
            } else {
                node1.next = new Node(i);
                node1 = node1.next;
            }
        }

        for (int i : b) {
            if (node2 == null) {
                node2 = new Node(i);
                root2 = node2;
            } else {
                node2.next = new Node(i);
                node2 = node2.next;
            }
        }

        System.out.println(root1);
        System.out.println(root2);

        Node root = mergeOrder(null, root2);
        System.out.println(root);
    }

    // 合并两个有序链表并去重
    public static Node mergeOrder(Node node1, Node node2) {
        Node a = node1, b = node2;
        Node t = null, root = null;

        if (node1 == null && node2 == null) {
            return null;
        } else if (node1 == null) {
            Node pre = null;
            while (b != null) {
                if (pre != null && b.val == pre.val) {
                    pre.next = b.next;
                }
                pre = b;
                b = b.next;
            }

            return node2;
        } else if (node2 == null) {
            Node pre = null;
            while (a != null) {
                if (pre != null && a.val == pre.val) {
                    pre.next = a.next;
                }
                pre = a;
                a = a.next;
            }
            return node1;
        }

        while (a != null && b != null) {
            if (t != null) {
                if (t.val == a.val) {
                    a = a.next;
                    continue;
                }
                if (t.val == b.val) {
                    b = b.next;
                    continue;
                }
            }
            if (a.val < b.val) {
                if (t == null) {
                    t = a;
                    root = t;
                } else {
                    t.next = a;
                    t = t.next;
                }
                a = a.next;
            } else if (a.val > b.val) {
                if (t == null) {
                    t = b;
                    root = t;
                } else {
                    t.next = b;
                    t = t.next;
                }
                b = b.next;
            } else {
                if (t == null) {
                    t = a;
                    root = t;
                } else {
                    t.next = a;
                    a = a.next;
                    t = t.next;
                }
            }
        }

        while (a != null) {
            if (t.val != a.val) {
                t.next = a;
                t = t.next;
            }
            a = a.next;
        }
        while (b != null) {
            if (t.val != b.val) {
                t.next = b;
                t = t.next;
            }
            b = b.next;
        }
        return root;
    }

    // 添加节点
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

    // 打印节点
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
