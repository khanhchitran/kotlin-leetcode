package problems;

public class JumpGame2 {
    public int jump(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;

        int[] dp = new int[n];
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (nums[j] + j >= i) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                    break;
                }
            }
        }

        return dp[n - 1];
    }
}
