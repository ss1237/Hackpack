import java.util.*;
import java.io.*;

//Finds minimum spanning tree, kinda different from most implementations online
//Prim's is better for dense graphs (E >> V)

public class PrimMST {
    public static void main(String[] args) throws IOException {
        FastScanner in = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        int m = in.nextInt();
        boolean[] vis = new boolean[n + 1];
        ArrayList<int[]>[] adj = new ArrayList[n + 1];
        Arrays.setAll(adj, x -> new ArrayList<>());

        for (int i = 0; i < m; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            int w = in.nextInt();
            adj[u].add(new int[] {u, v, w});
            adj[v].add(new int[] {v, u, w});
        }

        long dist = prim(1, adj, vis);
        out.println((dist > 0) ? dist : "IMPOSSIBLE");

        out.close();

    }

    static long prim(int src, ArrayList<int[]>[] adj, boolean[] vis) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x[2]));
        pq.addAll(adj[src]);
        long dist = 0;
        vis[1] = true;
        int ct = 1;

        while (!pq.isEmpty() && ct < vis.length - 1) {
            int[] cur = pq.poll();
            if (vis[cur[0]] && vis[cur[1]]) continue;

            vis[cur[1]] = true;
            ct++;
            dist += cur[2];
            for (int[] edge : adj[cur[1]]) {
                if (!vis[edge[1]]) {
                    pq.add(edge);
                }
            }
        }

        return (ct == vis.length - 1) ? dist : -1;
    }
}
