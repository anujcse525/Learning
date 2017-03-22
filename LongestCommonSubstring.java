class LongestCommonSubstring {
 
	static int longestCommonSubstring(String str1, String str2) {
		int m = str1.length();
		int n = str2.length();
 
		int[][] dp = new int[m+1][n+1];
 
		int maxLen = Integer.MIN_VALUE, suffixEnd = -1;
		for(int i=1;i<m+1;i++) {
			for(int j=1;j<n+1;j++) {
				if(str1.charAt(i-1) == str2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + 1;
					if(dp[i][j] > maxLen) {
						maxLen = dp[i][j];
						suffixEnd = i;
					}
				}
				else
					dp[i][j] = 0;
			}
		}
 
		System.out.println("\nLongest Common Substring:");
		System.out.println(str1.substring(suffixEnd-maxLen,suffixEnd));
 
		return maxLen;
	}
 
	public static void main(String[] args) {
		String str1 = "OldSite:GeeksforGeeks.org";
		String str2 = "NewSite:GeeksQuiz.com";
 
		System.out.println("String1 : " + str1);
		System.out.println("String2 : " + str2);
 
		System.out.println("\nLength of Longest Common Substring is " + longestCommonSubstring(str1,str2) + ".");
	}
}
