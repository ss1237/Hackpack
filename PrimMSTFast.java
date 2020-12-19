//O(N^2) variation of Prim's, works very well on dense graphs since requires only O(N) memory

import java.util.*;
import java.io.*;

public class PrimMSTFast {
    public static void main(String[] args) throws IOException {
        FastScanner in = new FastScanner(System.in);
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        
		int n = in.nextInt();
		int m = in.nextInt();
		boolean[] vis = new boolean[n + 1];
		int[][] adj = new int[n + 1][n + 1];
        long[] minEdge = new long[n + 1];

        for (int[] x : adj) Arrays.fill(x, Integer.MAX_VALUE);
        
        for (int i = 0; i < m; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            int w = in.nextInt();
            adj[u][v] = w;
            adj[v][u] = w;
        }

        long dist = 0;
        
        for (int i = 1; i <= n; i++) minEdge[i] = Integer.MAX_VALUE;
        minEdge[1] = 0;
        
        for (int i = 0; i < n; i++) {
        	int min = 0;
        	for (int j = 1; j <= n; j++) {
        		if (!vis[j] && (min == 0 || minEdge[j] < minEdge[min])) min = j;
        	}
        	
        	if (minEdge[min] == Integer.MAX_VALUE) {
        		out.println("No MST!");
        		out.close();
        		return;
        	}
        	
        	vis[min] = true;
        	dist += minEdge[min];
        	
        	for (int to = 1; to <= n; to++) {
        		if (adj[min][to] < minEdge[to]) {
        			minEdge[to] = adj[min][to];
        		}
        	}
        }
		
        out.println(dist);
		out.close();
		
    }
}
