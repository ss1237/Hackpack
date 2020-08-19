import java.util.*;
import java.io.*;

//O(nm) to find shortest path from a single source
//Works with negative edges and used to find negative cycles
//Can be modified for greatest distance and positive cycles

public class BellmanFord {
    static long INF = (long) 1e14;

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
        Arrays.fill(dist, INF);
        dist[0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int[] edge : adj[j]) {
                    if (dist[j] + edge[1] < dist[edge[0]]) {
                        if (i == n - 1) {
                            System.out.println("NEG CYCLE"); //contains negative cycle
                            return;
                        }
                        dist[edge[0]] = dist[j] + edge[1];
                    }
                }
            }
        }

        for (long x : dist) System.out.println(x);
        //dist now contains the least distance from 0 to every other vertex
        out.close();

    }
}
