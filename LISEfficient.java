import java.util.*;
import java.io.*;

public class LISEfficient {
    public static void main(String[] args) {
        FastScanner in = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        TreeMap<Integer, Integer> seq = new TreeMap<>();
        int size = 0;

        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            Integer ceil = seq.ceilingKey(a);
            if (ceil != null && seq.get(ceil) != 0) {
                seq.put(ceil, seq.get(ceil) - 1);
                size--;
            }
            seq.put(a, seq.getOrDefault(a, 0) + 1);
            size++;
        }

        out.println("Size: " + size);
        out.close();

    }
}
