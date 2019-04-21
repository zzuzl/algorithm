package cn.zzuzl.search;

import cn.zzuzl.Base;

// 找第k大的元素
public class KthItem extends Base {

    static int kth(int[] a, int k) {
        if (k < 1 || k > a.length) {
            return -1;
        }
        int low = 0, high = a.length-1;
        int index = getIndex(a, low, high);
        while (index + 1 != k) {
            if (index + 1 > k) {
                high = index - 1;
            } else {
                low = index + 1;
            }
            index = getIndex(a, low, high);
        }

        return a[index];
    }

    static int getIndex(int[] a, int low, int high) {
        int p = a[high];
        int index = low;
        for (int i=low;i<high;i++) {
            if (a[i] > p) {
                int temp = a[i];
                a[i] = a[index];
                a[index] = temp;
                index ++;
            }
        }
        int temp = a[index];
        a[index] = a[high];
        a[high] = temp;
        return index;
    }

    public static void main(String[] args) {
        System.out.println(kth(a, 5));
    }
}
