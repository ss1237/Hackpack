import java.util.*;
import java.io.*;

public class DSU {

    static int numComponents, maxSize;

    public static void main(String[] args) throws IOException {
        FastScanner in = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        int m = in.nextInt();

        numComponents = n;
        maxSize = 1;
        int[] root = new int[n + 1];
        int[] size = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            size[i] = 1;
            root[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            union(a, b, root, size);
            out.println(numComponents + " " + maxSize);
        }

        out.close();

    }


    static void union(int a, int b, int[] root, int[] size) {
        if (find(a, root) != find(b, root)) {
            numComponents--;
            if (size[root[a]] > size[root[b]]) {
                size[root[a]] += size[root[b]];
                root[root[b]] = root[a];
                maxSize = Math.max(maxSize, size[root[a]]);
            }
            else {
                size[root[b]] += size[root[a]];
                root[root[a]] = root[b];
                maxSize = Math.max(maxSize, size[root[b]]);
            }
        }
    }

    static int find(int a, int[] root) {
        if (root[a] == a) return a;
        return root[a] = find(root[a], root);
    }
}
