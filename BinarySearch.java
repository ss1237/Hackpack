import java.util.*;
import java.io.*;

//Jacob's binary search!

public class BinarySearch {
    public static void main(String[] args) throws IOException {
        FastScanner in = new FastScanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		//We establish the bounds
		//f will store the most recent/accurate value
		int lo = 0, hi = 100000000;

		// As long as this loop is processing, we need to consider
		//   values in the INCLUSIVE range [lo, hi].
		while(lo <= hi) {
			m = (lo + hi) / 2;
			if(canDo(m)) {
				lo = m + 1;
			}
			else {
				hi = m - 1;
			}
		}
		
	    	//lo > hi
		System.out.println(lo + " " + hi);
		
		out.close();
		
    }
}
