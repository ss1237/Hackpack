import java.util.*;
import java.io.*;

//Dijkstra's single source shortest distance

public class Dijkstra {
    static long MAX = (long) 1e14; //any max value >= maxweight*numnodes

    public static void main(String[] args) throws IOException {
        FastScanner in = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        int m = in.nextInt();
        ArrayList<int[]>[] adj = new ArrayList[n];
        Arrays.setAll(adj, x -> new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int u = in.nextInt() - 1;
            int v = in.nextInt() - 1;
            int w = in.nextInt();
            adj[u].add(new int[] {v, w});
        }

        long[] dist = new long[n];
        Arrays.setAll(dist, x -> MAX);
        dijkstra(0, adj, dist);
		
		//prints min distances
        for (int i = 0; i < n; i++) {
            out.print(dist[i] + " ");
        }
        out.close();

    }

    static void dijkstra(int src, ArrayList<int[]>[] adj, long[] dist) {
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        boolean[] vis = new boolean[dist.length];
        dist[src] = 0;
        pq.add(new long[] {src, 0});

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            int vtx = (int) cur[0];

            if (dist[vtx] != cur[1]) continue;
            vis[vtx] = true;

            for (int[] edge : adj[vtx]) {
                if (!vis[edge[0]]) {
                    if (dist[vtx] + edge[1] < dist[edge[0]]) {
                        dist[edge[0]] = dist[vtx] + edge[1];
                        pq.add(new long[] {edge[0], dist[vtx] + edge[1]});
                    }
                }
            }

        }
    }
}
