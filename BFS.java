//BFS on a graph, this program doesn't really do anything

import java.util.*;
import java.io.*;

public class BFS {
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
                bfs(adj, vis, i);
            }
        }

    }

    static void bfs(ArrayList<Integer>[] adj, boolean[] vis, int node) {
        ArrayDeque<Integer> nodeQ = new ArrayDeque<>();
        nodeQ.add(node);
        while (nodeQ.size() > 0) {
            int cur = nodeQ.poll();
            for (int to : adj[cur]) {
                if (!vis[to]) {
                    vis[to] = true;
                    nodeQ.add(to);
                }
            }
        }
    }
}
