package cn.zzuzl.structrue;

import cn.zzuzl.Base;

// 有序数组
public class OrderedArray extends Base {
    private int[] data;
    private int size = 0;
    private int count = 0;

    public OrderedArray(int capacity) {
        this.data = new int[capacity];
        this.size = capacity;
    }

    public void insert(int val) {
        if (count >= size) {
            throw new RuntimeException("空间不足");
        }

        if (count == 0) {
            data[count ++] = val;
            return;
        }

        int i=count-1;
        while (i >= 0 && data[i] > val) {
            data[i+1] = data[i];
            i --;
        }
        data[i + 1] = val;
        count++;
    }

    public void delete(int val) {
        int num = 0, index = -1;
        for (int i=0;i<count;i++) {
            if (data[i] == val) {
                num ++;
                index = i;
            } else if (data[i] > val) {
                break;
            }
        }
        if (index == -1) {
            return;
        }
        for (int i=index + 1;i<count;i++) {
            data[i-num] = data[i];
        }
        count = count - num;
    }

    public void modify(int index, int val) {
        if (index >= count || index < 0) {
            throw new RuntimeException("");
        }
        if (data[index] < val) {
            while (index < count -1 && data[index] < val) {
                data[index] = data[index + 1];
                index ++;
            }
            data[index] = val;
        } else if (data[index] > val) {
            while (index > 0 && data[index] > val) {
                data[index] = data[index - 1];
                index --;
            }
            data[index] = val;
        }
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<count;i++) {
            sb.append(data[i]).append(" ");
        }
        System.out.println(sb.toString());
    }

    public static OrderedArray mergeOrdered(OrderedArray array1, OrderedArray array2) {
        if (array1 == null) {
            return array2;
        } else if (array2 == null) {
            return array1;
        }

        OrderedArray array = new OrderedArray(array1.count + array2.count);
        int i = 0, j=0;
        int[] a1 = array1.data,a2 = array2.data;
        for (int index = 0;index<array1.count;index++) {
            array.insert(a1[index]);
        }
        for (int index = 0;index<array2.count;index++) {
            array.insert(a2[index]);
        }
        return array;
    }

    public static void main(String[] args) {
        OrderedArray array = new OrderedArray(4);
        array.insert(10);
        array.insert(2);
        array.insert(7);
        array.insert(2);
        array.modify(2, 11);
        // array.delete(2);
        array.print();
    }

}
