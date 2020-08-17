static class BIT {
    int[] BIT;

    public BIT(int n) {
        BIT = new int[n + 1];
    }

//1-idxed
    public void update(int idx, int val) {
        while (idx < BIT.length) {
            BIT[idx] += val;
            idx += idx & -idx;
        }
    }

//1-idxed
    public int query(int idx) {
        int sum = 0;
        while (idx > 0) {
            sum += BIT[idx];
            idx ^= idx & -idx;
        }
        return sum;
    }
}
