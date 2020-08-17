//Segment Tree implementation for range sum updates and queries
static class SegTree {
	long[] tree;
	int[] left, right;
	int n;

	public SegTree(int[] nums) {
		n = (int) Math.pow(2, Math.ceil(Math.log(nums.length) / Math.log(2)));
		tree = new long[2 * n];
		left = new int[2 * n];
		right = new int[2 * n];
		for (int i = 0; i < n; i++) {
			tree[i + n] = (i < nums.length) ? nums[i] : 0;
			left[i + n] = i;
			right[i + n] = i;
		}
		for (int i = n - 1; i > 0; i--) {
			tree[i] = tree[i * 2] + tree[i * 2 + 1];
			left[i] = left[i * 2];
			right[i] = right[i * 2 + 1];
		}
	}

	long query(int ll, int rr, int cur) {
		if (ll <= left[cur] && rr >= right[cur]) {
			return tree[cur];
		}
		else if (ll > right[cur] || rr < left[cur]) {
			return 0;
		}
		else {
			return query(ll, rr, cur * 2) + query(ll, rr, cur * 2 + 1);
		}
	}

	void update(int idx, long val) {
		int cur = idx + n;
		long old = tree[idx + n];
		while (cur != 0) {
			tree[cur] += val - old;
			cur /= 2;
		}
	}

	void print() {
		for (int i = 0; i < 2 * n; i++) {
			System.out.println(i + " " + tree[i] + " " + left[i] + " " + right[i]);
		}
		System.out.println();
	}
}
