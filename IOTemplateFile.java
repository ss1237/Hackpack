import java.util.*;
import java.io.*;

public class IOTemplateFile {
    static String filename = "";
	
    public static void main(String[] args) throws IOException {
	FastScanner in = new FastScanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
    	//FastScanner in = new FastScanner(new FileInputStream(filename + ".in"));
	//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(filename + ".out")));
        
		
	out.close();
		
    }
	

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;
        public FastScanner(InputStream i) {
            br = new BufferedReader(new InputStreamReader(i));
            st = new StringTokenizer("");
        }
        public String next() throws IOException {
            if (st.hasMoreTokens()) {
                return st.nextToken();
            }
            else
                st = new StringTokenizer(br.readLine());
            return next();
        }
        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }
		public String nextLine() throws IOException {
            if (!st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
                return nextLine();
            }

            String ret = "";
            while (st.hasMoreTokens()) {
                ret += st.nextToken();
            }
            return ret;
        }
        public int[] nextIntArr(int size) throws IOException {
            int[] arr = new int[size];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = nextInt();
            }
            return arr;
        }
        public long[] nextLongArr(int size) throws IOException {
            long[] arr = new long[size];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = nextLong();
            }
            return arr;
        }
		public double[] nextDoubleArr(int size) throws IOException {
            double[] arr = new double[size];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = nextDouble();
            }
            return arr;
        }
    }
}
