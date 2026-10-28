class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int mod = 1_000_000_007;
        int[] stack = new int[n];
        int top = -1;
        long sum = 0;

        for (int i = 0; i <= n; i++) {
            while (top >= 0 && (i == n || arr[stack[top]] >= arr[i])) {
                int mid = stack[top--];
                int left = top >= 0 ? stack[top] : -1;
                int right = i;

                long count = (long) (mid - left) * (right - mid);
                sum = (sum + count * arr[mid]) % mod;
            }

            if (i < n) {
                stack[++top] = i;
            }
        }

        return (int) sum;
    }
}