public class Solution {
    public int minDistance(String word1, String word2) {
        if(word1 == null || word2 == null) {
            return 0;
        }
        
        int len1 = word1.length();
        int len2 = word2.length();
        if(len2 == 0)   return len1;
        if(len1 == 0)   return len2;
        int[][] dp = new int[len1 + 1][len2 + 2];
        
        for(int i = 0; i < len1 + 1; i++) {
            dp[i][0] = i;
        }
        
        for(int j = 0; j < len2 + 1; j++) {
            dp[0][j] = j;
        }
        
        for(int i = 1; i < len1 + 1; i++) {
            for(int j = 1; j < len2 + 1; j++) {
                char c1 = word1.charAt(i - 1);
                char c2 = word2.charAt(j - 1);
                if(c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                }
            }
        }
        return dp[len1][len2];
    }
}
