class Solution {
   public int minCost(int n, int[] cuts) {
        List<Integer> A = new ArrayList<>();
        for (int a : cuts) {
            A.add(a);
        }
        A.add(0);
        A.add(n);
        Collections.sort(A);
        int k = A.size();
        int[][] dp = new int[k][k];
        for (int d = 2; d < k; ++d) {
            for (int i = 0; i < k - d; ++i) {
                dp[i][i + d] = 1000000000;
                for (int m = i + 1; m < i + d; ++m) {
                    dp[i][i + d] = Math.min(dp[i][i + d], dp[i][m] + dp[m][i + d] + A.get(i + d) - A.get(i));
                }
            }
        }
        return dp[0][k - 1];
    }
}