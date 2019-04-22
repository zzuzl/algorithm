package cn.zzuzl.test;

// 斐波那契数列
public class Fb {

    public static int f1(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return f1(n-1) + f1(n-2);
    }

    public static int f2(int n) {
        int first = 0, second = 1;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        while (n>=2) {
            int temp = second + first;
            first = second;
            second = temp;
            n--;
        }
        return second;
    }

    public static void main(String[] args) {
        System.out.println(f2(8));
    }

}
