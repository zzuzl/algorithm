package cn.zzuzl.sort;

import cn.zzuzl.Base;

import java.util.Arrays;

public class BubbleSort extends Base {

    public static void main(String[] args) {
        sort(a, a.length);

        System.out.println(Arrays.toString(a));
    }

    static void sort(int[] a, int n) {
        boolean swaped = false;

        int index = n-1;
        do {
            swaped = false;
            for (int i=0;i<index;i++) {
                if (a[i] > a[i+1]) {
                    int temp = a[i];
                    a[i] = a[i+1];
                    a[i+1] = temp;
                    swaped = true;
                }
            }
            index--;
        } while (swaped);

    }

}
