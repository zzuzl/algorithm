package cn.zzuzl.structrue;

import java.util.LinkedList;
import java.util.Queue;

// 图  邻接表（本类）和邻接矩阵
public class Graph {
    private int n;
    private LinkedList<Integer>[] adj;
    boolean found = false;

    public Graph(int size) {
        this.n = size;
        this.adj = new LinkedList[size];

        for (int i=0;i<n;i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }

    void add(int s, int t) {
        adj[s].add(t);
        adj[t].add(s);
    }

    // 广度优先搜索
    void bfs(int s, int t) {
        if (s == t) {
            return;
        }
        boolean[] visited = new boolean[n];
        visited[s] = true;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(s);
        int[] prev = new int[n];
        for (int i=0;i<n;i++) {
            prev[i] = -1;
        }
        while (!queue.isEmpty()) {
            int val = queue.poll();
            for (int i=0;i<adj[val].size();i++) {
                int q = adj[val].get(i);
                if (!visited[q]) {
                    prev[q] = val;
                    if (q == t) {
                        // print
                        return;
                    }
                    visited[q] = true;
                    queue.add(q);
                }
            }
        }
    }

    // 深度优先搜索 递归
    void dfs(int s, int t) {
        found = false;
        boolean[] visited = new boolean[n];
        int[] prev = new int[n];
        for (int i=0;i<n;i++){
            prev[i] = -1;
        }
        recurDfs(s, t, prev, visited);
    }

    void recurDfs(int w, int t,int[] prev, boolean[] visited) {
        if (found) {
            return;
        }
        visited[w] = true;
        if (w == t) {
            found = true;
            return;
        }
        for (int i=0;i<adj[w].size();i++) {
            int q = adj[w].get(i);

            if (!visited[q]) {
                prev[q] = w;
                recurDfs(q, t, prev, visited);
            }
        }
    }
}
