package cn.zzuzl.structrue;

import java.util.Arrays;

// 大顶堆
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

    // 添加，自下往上堆化
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

    // 删除堆顶元素
    public void deleteTop() {
        a[1] = a[count];
        a[count] = 0;
        count --;

        heapify(count,1);
    }

    private void swap(int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // 自上往下堆化
    public void heapify(int n,int i) {
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

    // 构建堆
    public void buildHeap() {
        for (int i=count/2;i>=1;i--) {
            heapify(count,i);
        }
    }

    // 堆排序
    public void sort() {
        buildHeap();
        int k=count;
        while (k>1) {
            swap(k,1);
            k--;
            heapify(k, 1);
        }
    }

    // 优先级队列合并k个有序数组  每次从k个数组中取一条，放入k大的小顶堆，堆化，把第一条放入目标数组，并从第一条所在数组中拿下一条
    // int[] mergeOrderedArray(int[][] data);

    // top K
    static int[] topK(int[] data, int k) {
        int[] arr = new int[k];
        for (int i=0;i<k;i++) {
            arr[i] = data[i];
        }

        Heap heap = new Heap(arr, k);
        heap.buildHeap();

        for (int i=k;i<data.length;i++) {
            if (data[i] > heap.a[1]) {
                heap.deleteTop();
                heap.add(data[i]);
            }
        }
        return heap.a;
    }

    public void print() {
        System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args) {
        Heap heap = new Heap(new int[]{20}, 10);
        heap.add(30);
        heap.add(10);
        heap.add(25);
        heap.sort();
        heap.print();
    }
}
