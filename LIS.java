//Finds longest increasing subsequence O(nlogn)

import java.util.*;
import java.io.*;

public class LIS {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        int[] nums = new int[n];
        int[] tailTable = new int[n]; //tailTable[x] is least tail of subsequence with len x+1
        nums[0] = in.nextInt();
        tailTable[0] = nums[0];
        int len = 1;

        for (int i = 1; i < n; i++) {
            nums[i] = in.nextInt();
            if (nums[i] < tailTable[0]) { //least element seen so far
                tailTable[0] = nums[i];
            }
            else if (nums[i] > tailTable[len - 1]) { //greatest element seen so far
                tailTable[len++] = nums[i];
            }
            else { //somewhere in the middle, find least idx such that tail[idx] >= nums[i]
                tailTable[ceilIdx(tailTable, -1, len - 1, nums[i])] = nums[i];
            }
        }
        out.println(len);
        out.close();

    }

    //bin searches in nums to find least i such that nums[i] >= key
    static int ceilIdx(int[] nums, int l, int r, int key) {
        while (r - l > 1) {
            int m = (r + l) / 2;
            if (nums[m] >= key) {
                r = m;
            }
            else {
                l = m;
            }
        }
        return r;
    }

}
