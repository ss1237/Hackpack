//Also contains code for factorial, inverse factorial, and inverse given a mod

import java.util.*;
import java.io.*;

public class Combinations {
	static long mod = 998244353; //Has to be prime mod
	static long[] fact, invFact, inv;
	static int maxN = (int) 1e5;
	
	static long inv(long n) {
		if (n == 1) return 1;
		return inv(mod % n) * (mod - mod / n) % mod;
	}
	
	public static void main(String[] args) throws IOException {
		FastScanner in = new FastScanner(System.in);
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		
		fact = new long[maxN + 1];
		invFact = new long[maxN + 1];
		fact[0] = invFact[0] = 1;
		
		for (int i = 1; i <= maxN; i++) {
			fact[i] = fact[i - 1] * i % mod;
			invFact[i] = invFact[i - 1] * inv(i) % mod;
		}
		
		int n = in.nextInt();
		int r = in.nextInt();
		
		System.out.println(fact[n] * invFact[r] % mod * invFact[n - r] % mod);
		
	}
}