package cn.zzuzl.sort;

import cn.zzuzl.Base;

import java.util.Arrays;

public class QuickSort extends Base {

    public static void main(String[] args) {
        sort(a, 0, a.length -1);

        System.out.println(Arrays.toString(a));
    }

    static void sort(int[] a, int low, int high) {
        if (low >= high) {
            return;
        }

        int index = getIndex(a, low, high);
        sort(a, low, index - 1);
        sort(a, index + 1, high);
    }

    static int getIndex(int[] a, int low, int high) {
        int p = a[high];
        int index = low;
        for (int i=index;i<high;i++) {
            if (a[i] < p) {
                int temp = a[index];
                a[index] = a[i];
                a[i] = temp;
                index++;
            }
        }
        int temp = a[index];
        a[index] = a[high];
        a[high] = temp;
        return index;
    }

}
