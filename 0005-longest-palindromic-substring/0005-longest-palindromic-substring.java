class Solution {
    int maxi = Integer.MIN_VALUE;
    int endIndex = 0;

    public String longestPalindrome(String s) 
    {
        String s1="";
        for(int i=s.length()-1;i>=0;i--)
        {
            s1=s1+s.charAt(i);
        }
        int[][] dp = new int[s.length() + 1][s1.length() + 1];

        for (int i = 1; i <= s.length(); i++)
         {
            for (int j = 1; j <= s1.length(); j++) {
                if (s.charAt(i - 1) == s1.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    if (dp[i][j] > maxi) {
                        // Verify if this substring is a palindrome
                        int start = i - dp[i][j];
                        int end = i - 1;
                        if (isPalindrome(s, start, end)) {
                            maxi = dp[i][j];
                            endIndex = i - 1;
                        }
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        
        return s.substring(endIndex - maxi + 1, endIndex + 1);
    }

    private boolean isPalindrome(String s, int start, int end)
     {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }


    
}