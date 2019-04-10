package cn.zzuzl.sort;

import cn.zzuzl.Base;

import java.util.Arrays;

public class SelectionSort extends Base {

    public static void main(String[] args) {
        sort(a, a.length);

        System.out.println(Arrays.toString(a));
    }

    static void sort(int[] a, int n) {
        for (int i=0;i<n;i++) {
            int min = a[i];
            int minIndex = i;

            for (int j=i+1;j<n;j++) {
                if (a[j] < min) {
                    min = a[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = a[i];
                a[i] = a[minIndex];
                a[minIndex] = temp;
            }
        }

    }

}
