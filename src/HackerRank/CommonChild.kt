package HackerRank

class CommonChild {
    fun commonChild(s1: String, s2: String): Int {
        val n = s1.length
        val m = s2.length

        // DP table initialization
        val dp = Array(n + 1) { IntArray(m + 1) }

        // Fill the DP table
        for (i in 1..n) {
            for (j in 1..m) {
                if (s1[i - 1] == s2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1
                } else {
                    dp[i][j] = maxOf(dp[i - 1][j], dp[i][j - 1])
                }
            }
        }

        // Return the value in the bottom-right corner of the table
        return dp[n][m]
    }
}
