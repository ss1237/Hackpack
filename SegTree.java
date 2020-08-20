import java.util.*;
import java.io.*;

public class SegTree {
    public static void main(String[] args) throws IOException {
        FastScanner in = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int[] nums = new int[] {1, 3, 4, 5, 8, 4, 29, 6, 10, 15, 4, 3, 2};
        ST st = new ST(nums);
        out.println(st.rangeMax(0, 7, 1));
        out.println(st.rangeMin(0, 7, 1));
        out.println(st.rangeSum(0, 7, 1));
        st.rangeInc(22, 1, 4, 1);
        st.rangeInc(-3, 0, 3, 1);
        out.println(st.rangeMax(0, 5, 1));
        out.println(st.rangeMin(0, 5, 1));
        out.println(st.rangeSum(0, 5, 1));

        out.close();

    }

    //Segment Tree implementation for range sum, min, max, and updates
    static class ST {
        int[] left, right, sum, max, min, lazy;
        int n;

        public ST(int[] nums) {
            n = (int) Math.pow(2, Math.ceil(Math.log(nums.length) / Math.log(2)));
            left = new int[2 * n];
            right = new int[2 * n];
            sum = new int[2 * n];
            max = new int[2 * n];
            min = new int[2 * n];
            lazy = new int[2 * n];

            for (int i = 0; i < n; i++) {
                sum[i + n] = (i < nums.length) ? nums[i] : 0;
                max[i + n] = (i < nums.length) ? nums[i] : 0;
                min[i + n] = (i < nums.length) ? nums[i] : 0;
                left[i + n] = i;
                right[i + n] = i;
            }
            for (int i = n - 1; i > 0; i--) {
                sum[i] = sum[i * 2] + sum[i * 2 + 1];
                max[i] = Math.max(max[i * 2], max[i * 2 + 1]);
                min[i] = Math.min(min[i * 2], min[i * 2 + 1]);
                left[i] = left[i * 2];
                right[i] = right[i * 2 + 1];
            }
        }

        int rangeSum(int ll, int rr, int i) {
            if (ll <= left[i] && rr >= right[i]) {
                return sum[i] + lazy[i] * (right[i] - left[i] + 1);
            }
            else if (ll > right[i] || rr < left[i]) {
                return 0;
            }
            else {
                prop(i);
                int left = rangeSum(ll, rr, i * 2);
                int right = rangeSum(ll, rr, i * 2 + 1);
                update(i);
                
                return left + right;
            }
        }

        int rangeMax(int ll, int rr, int i) {
            if (ll <= left[i] && rr >= right[i]) {
                return max[i];
            }
            else if (ll > right[i] || rr < left[i]) {
                return Integer.MIN_VALUE;
            }
            else {
                prop(i);
                int left = rangeMax(ll, rr, i * 2);
                int right = rangeMax(ll, rr, i * 2 + 1);
                update(i);

                return Math.max(left, right);
            }
        }

        int rangeMin(int ll, int rr, int i) {
            if (ll <= left[i] && rr >= right[i]) {
                return min[i] + lazy[i];
            }
            else if (ll > right[i] || rr < left[i]) {
                return Integer.MAX_VALUE;
            }
            else {
                prop(i);
                int left = rangeMin(ll, rr, i * 2);
                int right = rangeMin(ll, rr, i * 2 + 1);
                update(i);
                
                return Math.min(left, right);
            }
        }

        void prop(int i) {
            lazy[2 * i] += lazy[i];
            lazy[2 * i + 1] += lazy[i];
            lazy[i] = 0;
        }
        
        void update(int i) {
            min[i] = Math.min(min[2 * i] + lazy[2 * i], min[2 * i + 1] + lazy[2 * i + 1]);
            max[i] = Math.max(max[2 * i] + lazy[2 * i], max[2 * i + 1] + lazy[2 * i + 1]);
            
            sum[i] = sum[2 * i] + (right[2 * i] - left[2 * i] + 1) * lazy[2 * i];
            sum[i] += sum[2 * i + 1] + (right[2 * i + 1] - left[2 * i + 1] + 1) * lazy[2 * i + 1];
        }
        
        void rangeInc(int val, int ll, int rr, int i) {
            if (ll <= left[i] && rr >= right[i]) {
                lazy[i] += val;
            }
            else if (ll > right[i] || rr < left[i]) {
            }
            else {
                prop(i);
                rangeInc(val, ll, rr, 2 * i);
                rangeInc(val, ll, rr, 2 * i + 1);
                update(i);
            }
        }
    }
}
