//Shortest paths from all to all, O(n^3)
import java.util.*;
import java.io.*;

public class FloydWarshall {
    static long MAX = (long) 1e13;

    public static void main(String[] args) throws IOException {
        FastScanner in = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        int m = in.nextInt();
        int q = in.nextInt();
        long[][] dist = new long[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dist[i], MAX);
            dist[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            long c = in.nextLong();
            dist[u][v] = Math.min(dist[u][v], c);
            dist[v][u] = Math.min(dist[u][v], c);
        }


//all possible paths through k, for every i and j
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

//queries for distance from u to v, -1 if unreachable
        for (int i = 0; i < q; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            if (dist[u][v] >= MAX) {
                System.out.println(-1);
            }
            else {
                System.out.println(dist[u][v]);
            }
        }


    }
}
