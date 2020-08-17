//DFS on a graph, same as BFS but with stack (not recursive)

import java.util.*;
import java.io.*;

public class DFS {
    public static void main(String[] args) throws IOException {
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
        Stack<Integer> nodes = new Stack<>();
        nodes.push(node);
        while (nodes.size() > 0) {
            int cur = nodes.pop();
            for (int to : adj[cur]) {
                if (!vis[to]) {
                    vis[to] = true;
                    nodes.add(to);
                }
            }
        }
    }
}
