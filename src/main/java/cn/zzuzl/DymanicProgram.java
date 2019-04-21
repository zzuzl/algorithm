package cn.zzuzl;

// 01背包问题
public class DymanicProgram {
    private int maxW = Integer.MIN_VALUE; // 存储背包中物品总重量的最大值
    private int[] weight = new int[]{2,2,4,6,3};
    private int n=5;// 物品数量
    private int w = 9; //背包承受的最大重量
    private boolean[][] mem = new boolean[5][10];

    public void f(int i, int cw) {
        if (i == n || cw == w) {// cw==w 表示装满了，i==n 表示物品都考察完了
            if (cw > maxW) {
                maxW = cw;
            }
            return;
        }
        if (mem[i][cw]) {
            // 重复状态
            return;
        }
        mem[i][cw] = true;
        f(i+1, cw); // 选择不装第i个物品
        if (cw + weight[i] <= w) {
            f(i+1, cw + weight[i]);
        }
    }

    // cw 表示当前已经装进去的物品的重量和；i 表示考察到哪个物品了；
    // w 背包重量；items 表示每个物品的重量；n 表示物品个数
    // 假设背包可承受重量 100，物品个数 10，物品重量存储在数组 a 中，那可以这样调用函数：
    // f(0, 0, a, 10, 100)
    public void f1(int i, int cw, int[] items, int n, int w) {
        if (cw == w || i == n) { // cw==w 表示装满了 ;i==n 表示已经考察完所有的物品
            if (cw > maxW) maxW = cw;
            return;
        }
        f1(i+1, cw, items, n, w);
        if (cw + items[i] <= w) {// 已经超过可以背包承受的重量的时候，就不要再装了
            f1(i+1,cw + items[i], items, n, w);
        }
    }

    // weight: 物品重量，n: 物品个数，w: 背包可承载重量
    // 动态规划
    public int knapsack(int[] weight, int n, int w) {
        boolean[][] states = new boolean[n][w+1]; // 默认值 false
        states[0][0] = true;  // 第一行的数据要特殊处理，可以利用哨兵优化
        states[0][weight[0]] = true;
        for (int i = 1; i < n; ++i) { // 动态规划状态转移
            for (int j = 0; j <= w; ++j) {// 不把第 i 个物品放入背包
                if (states[i-1][j] == true) states[i][j] = states[i-1][j];
            }
            for (int j = 0; j <= w-weight[i]; ++j) {// 把第 i 个物品放入背包
                if (states[i-1][j]==true) states[i][j+weight[i]] = true;
            }
        }
        for (int i = w; i >= 0; --i) { // 输出结果
            if (states[n-1][i] == true) return i;
        }
        return 0;
    }


}
