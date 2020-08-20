import java.util.*;
import java.io.*;

public class TopSort {
    public static void main(String[] args) throws IOException {
        FastScanner in = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        int m = in.nextInt();
        ArrayList<Integer>[] adj = new ArrayList[n + 1];
        Arrays.setAll(adj, x -> new ArrayList<>());

        for (int i = 0; i < m; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            adj[u].add(v);
        }

        ArrayDeque<Integer> sorted = topSort(n, adj);

//detects if there is a cycle = impossible to top sort
        if (sorted.size() != n) {
            System.out.println("IMPOSSIBLE");
            return;
        }

        for (int x : sorted) {
            out.print(x + " ");
        }

        out.close();

    }

    static ArrayDeque<Integer> topSort(int n, ArrayList<Integer>[] adj) {
        ArrayDeque<Integer> ret = new ArrayDeque<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int[] deg = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j : adj[i]) {
                deg[j]++;
            }
        }
        for (int i = 1; i <= n; i++) {
            if (deg[i] == 0) queue.addLast(i);
        }

        while (!queue.isEmpty()) {
            int cur = queue.pollFirst();
            ret.addLast(cur);
            for (int to : adj[cur]) {
                if (--deg[to] == 0) queue.addLast(to);
            }
        }

        return ret;
    }
}
