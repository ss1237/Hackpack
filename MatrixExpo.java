public class MatrixExpo {
    static int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws IOException {
        int[][] base = new int[n][n];
        int[][] pow = expo(base, k);
    }

    static int[][] expo(int[][] base, long n) {
        int[][] ret = new int[base.length][base[0].length];
        for (int i = 0; i < base.length; i++) ret[i][i] = 1;

        while (n > 0) {
            if (n % 2 == 1) {
                ret = multiply(ret, base);
            }
            n /= 2;
            base = multiply(base, base);
        }
        return ret;
    }

    static int[][] multiply(int[][] a, int[][] b) {
        int[][] c = new int[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                for (int k = 0; k < b[0].length; k++) {
                    c[i][k] = (int) ((c[i][k] + (long) a[i][j] * b[j][k]) % mod);
                }
            }
        }
        return c;
    }

    static void print(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
