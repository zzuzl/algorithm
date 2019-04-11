package cn.zzuzl.sort;

import cn.zzuzl.Base;

import java.util.Arrays;

public class MergeSort extends Base {

    public static void main(String[] args) {
        sort(a, 0, a.length -1);

        System.out.println(Arrays.toString(a));
    }

    static void sort(int[] a, int low, int high) {
        if (low >= high) {
            return;
        }

        int mid = low + (high - low) / 2;
        sort(a, low, mid);
        sort(a, mid + 1, high);
        merge(a, low, mid, high);
    }

    static void merge(int[] a, int low, int mid, int high) {
        int[] temp = new int[high-low+1];
        int l = low, h = mid + 1;
        int i=0;

        while (l<=mid && h<=high) {
            if (a[l] < a[h]) {
                temp[i++] = a[l];
                l++;
            } else {
                temp[i++] = a[h];
                h++;
            }
        }
        while (l<=mid) {
            temp[i++] = a[l++];
        }
        while (h<=high) {
            temp[i++] = a[h++];
        }
        for (i = 0;i<temp.length;i++) {
            a[i + low] = temp[i];
        }

    }

}
