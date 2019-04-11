package cn.zzuzl.sort;

import cn.zzuzl.Base;

import java.util.Arrays;

public class InsertSort extends Base {

    public static void main(String[] args) {
        sort(a, a.length);

        System.out.println(Arrays.toString(a));
    }

    static void sort(int[] a, int n) {
        for (int i=1;i<n;i++) {
            int temp = a[i];
            int j = i-1;
            while (j >= 0 && a[j] > temp) {
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = temp;
        }
    }

}
