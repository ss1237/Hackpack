import java.util.*;
import java.io.*;

public class LISEfficient {
    public static void main(String[] args) throws IOException {
        FastScanner in = new FastScanner(System.in);
		    PrintWriter out = new PrintWriter(System.out);
                
        int n = in.nextInt();
        TreeSet<Integer> seq = new TreeSet<>();

        for (int i = 0; i < n; i++) {
          int a = in.nextInt();
          Integer ceil = seq.higher(a);
          if (ceil != null) seq.remove(ceil);
          seq.add(a);
        }

        out.println(seq.size());
        out.close();
		
    }
}
