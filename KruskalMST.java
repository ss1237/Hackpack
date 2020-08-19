import java.util.*;
import java.io.*;

//Uses DSU to implement Kruskal's algorithm for Minimum Spanning Tree

public class KruskalMST {

    static int numComponents;

    public static void main(String[] args) throws IOException {
        FastScanner in = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        int m = in.nextInt();
        PriorityQueue<long[]> edges = new PriorityQueue<>(Comparator.comparingLong(x -> x[2]));
        numComponents = n;

        for (int i = 0; i < m; i++) {
            long u = in.nextLong();
            long v = in.nextLong();
            long w = in.nextLong();
            edges.add(new long[] {u, v, w});
        }

        long dist = kruskal(n, edges);
        out.println((numComponents == 1) ? dist : "IMPOSSIBLE");

        out.close();

    }

    static long kruskal(int n, PriorityQueue<long[]> edges) {
        int[] root = new int[n + 1];
        int[] size = new int[n + 1];
        long dist = 0;
        for (int i = 1; i <= n; i++) {
            size[i] = 1;
            root[i] = i;
        }
        while (!edges.isEmpty()) {
            long[] cur = edges.poll();
            int a = (int) cur[0];
            int b = (int) cur[1];
            if (find(a, root) == find(b, root)) continue;
            union(a, b, root, size);
            dist += cur[2];
        }
        return dist;
    }

    static void union(int a, int b, int[] root, int[] size) {
        if (find(a, root) != find(b, root)) {
            numComponents--;
            if (size[root[a]] > size[root[b]]) {
                size[root[a]] += size[root[b]];
                root[root[b]] = root[a];
            }
            else {
                size[root[b]] += size[root[a]];
                root[root[a]] = root[b];
            }
        }
    }

    static int find(int a, int[] root) {
        if (root[a] == a) return a;
        return root[a] = find(root[a], root);
    }
}
