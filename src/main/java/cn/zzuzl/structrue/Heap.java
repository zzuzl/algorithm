package cn.zzuzl.structrue;

import java.util.Arrays;

public class Heap {
    private int[] a;
    private int n;
    private int count;

    public Heap(int[] a, int n) {
        this.a = new int[n + 1];
        for (int i = 0; i < a.length; i++) {
            this.a[1 + i] = a[i];
        }

        this.count = a.length;
        this.n = n;
    }

    public void add(int val) {
        if (count >= n - 1) {
            return;
        }
        int i = count + 1;
        a[i] = val;
        while (i / 2 > 0 && a[i] > a[i / 2]) {
            swap(i, i / 2);
            i = i / 2;
        }
        count ++;
    }

    public void deleteTop() {
        a[1] = a[count];
        a[count] = 0;
        count --;

        heapify(1);
    }

    private void swap(int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // 自上往下堆化
    public void heapify(int i) {
        while (true) {
            int maxPos = i;
            // 和left取最大
            if (2*i <=n && a[maxPos] < a[2*i]) {
                maxPos = 2*i;
            }
            // 再和right取最大
            if (2*i+1 <= n && a[maxPos] < a[2*i+1]) {
                maxPos = 2*i+1;
            }
            if (maxPos == i) {
                break;
            }

            swap(i, maxPos);
            i = maxPos;
        }
    }

    public void print() {
        System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args) {
        Heap heap = new Heap(new int[]{20}, 10);
        heap.add(30);
        heap.add(10);
        heap.add(25);
        heap.print();
    }
}
