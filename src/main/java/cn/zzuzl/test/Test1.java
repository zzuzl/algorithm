package cn.zzuzl.test;

// 求一个数二进制中1的个数
public class Test1 {

    // 每次往右移动一位
    public static int f1(int n) {
        if (n <= 0) {
            throw new RuntimeException();
        }

        int i=0, result = 0;
        do {
            if ((n & 1) == 1) {
                result++;
            }
            i++;
        } while (i<32);

        return result;
    }

    // n & (n-1) 用来消除最后一个1
    public static int f2(int n) {
        if (n <= 0) {
            throw new RuntimeException();
        }

        int result = 0;
        while (n > 0) {
            n = n & (n-1);
        }
        return result;
    }

    // 判断一个数是不是2的x次幂 通过n&(b-1)
    public static boolean is2(int n) {
        n = Math.abs(n);
        return (n & (n-1)) == 0;
    }

}
