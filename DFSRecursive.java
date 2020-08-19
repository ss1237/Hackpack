//DFS on a graph, same as BFS but recursive

import java.util.*;
import java.io.*;

public class DFSRecursive {
    public static void main(String[] args) throws IOException {
        FastScanner in = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        int m = in.nextInt();
        ArrayList<Integer>[] adj = new ArrayList[n + 1];
        boolean[] vis = new boolean[n + 1];
        Arrays.setAll(adj, x -> new ArrayList<>());

        for (int i = 0; i < m; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            adj[u].add(v);
            adj[v].add(u);
        }

        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                dfs(adj, vis, i);
            }
        }

    }

    static void dfs(ArrayList<Integer>[] adj, boolean[] vis, int node) {
        vis[node] = true;
        for (int to : adj[node]) {
            if (!vis[to]) {
                dfs(adj, vis, to);
            }
        }
    }
}
