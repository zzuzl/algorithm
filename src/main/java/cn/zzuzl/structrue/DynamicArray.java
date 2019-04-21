package cn.zzuzl.structrue;

import cn.zzuzl.Base;

// 动态扩容数组
public class DynamicArray extends Base {
    private int[] data;
    private int size = 0;
    private int count = 0;

    public DynamicArray(int size) {
        this.data = new int[size];
        this.size = size;
    }

    private void expand() {
        int[] newData = new int[size * 2];
        for (int i=0;i<size;i++) {
            newData[i] = data[i];
        }
        this.data = newData;
        this.size = this.size * 2;
        System.out.println("expand");
    }

    public void add(int val) {
        if (count >= size) {
            expand();
        }
        data[count ++] = val;
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<count;i++) {
            sb.append(data[i]).append(" ");
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        DynamicArray array = new DynamicArray(2);
        array.add(1);
        array.add(2);
        array.print();
        array.add(3);
        array.print();
    }

}
