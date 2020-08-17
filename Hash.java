//From HarmeyerHash

static class Hash implements Comparable<Hash> {
	static final long m1=8675309, m2=1_000_000_007;
	long v1=0, v2=0; int l=0;
	static final long s1=257, s2=619;
	static long[] s1Pow, s2Pow;
	static boolean precomped=false;

	void add(char o) {
		v1=(v1*s1+o)%m1;
		v2=(v2*s2+o)%m2;
		l++;
	}

	void add(int o) {
		v1=(v1*s1+o)%m1;
		v2=(v2*s2+o)%m2;
		l++;
	}

	public int compareTo(Hash o) {
		if (v1!=o.v1)
			return Long.compare(v1, o.v1);
		return Long.compare(v2, o.v2);
	}

	public boolean equals(Object o) {
		return compareTo((Hash)o)==0;
	}

	public int hashCode() {
		return (int)v1;
	}

	public Hash clone() {
		Hash toReturn=new Hash();
		toReturn.v1=v1;
		toReturn.v2=v2;
		toReturn.l=l;
		return toReturn;
	}

	static void precomp() {
		if (precomped) return;
		precomped=true;
		s1Pow=new long[1000_000];
		s2Pow=new long[1000_000];
		s1Pow[0]=s2Pow[0]=1;
		for (int i=1; i<s1Pow.length; i++)
			s1Pow[i]=(s1Pow[i-1]*s1)%m1;
		for (int i=1; i<s2Pow.length; i++)
			s2Pow[i]=(s2Pow[i-1]*s2)%m2;
	}

	//need fastPow if o can be longer than 10^6
	void append(Hash o) {
		precomp();
		v1=(v1*s1Pow[o.l]+o.v1)%m1;
		v2=(v2*s2Pow[o.l]+o.v2)%m2;
		l+=o.l;
	}

	public static Hash[] getPrefixHashes(char[] word) {
		precomp();
		int n=word.length;
		Hash[] toReturn=new Hash[n+1];
		toReturn[0]=new Hash();
		for (int i=1; i<=n; i++) {
			toReturn[i]=toReturn[i-1].clone();
			toReturn[i].add(word[i-1]);
		}
		return toReturn;
	}

	public static Hash[] getPrefixHashes(String word) {
		precomp();
		int n=word.length();
		Hash[] toReturn=new Hash[n+1];
		toReturn[0]=new Hash();
		for (int i=1; i<=n; i++) {
			toReturn[i]=toReturn[i-1].clone();
			toReturn[i].add(word.charAt(i - 1));
		}
		return toReturn;
	}

	//inclusive, exclusive
	public static Hash substringHash(Hash[] prefixHashes, int from, int to) {
		if (from==to)
			return new Hash();
		Hash old=prefixHashes[to].clone(), toSub=prefixHashes[from];
		int diff=to-from;
		old.v1=(old.v1-(toSub.v1*s1Pow[diff])%m1+m1)%m1;
		old.v2=(old.v2-(toSub.v2*s2Pow[diff])%m2+m2)%m2;
		old.l=to-from;
		return old;
	}

}
