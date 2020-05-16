class Solution {
	public int minimumDeleteSum(String a, String b) {

		int as = 0;
		int bs = 0;

		for(char c : a.toCharArray()){
			as += c;
		}

		for(char c : b.toCharArray()){
			bs += c;
		}

		int dp[][] = new int[a.length()+1][b.length()+1];
		int sum = 0;

		for(int i = 1; i < a.length()+1 ;i++){
			for(int j = 1 ; j < b.length()+1 ;j++){

				if(a.charAt(i-1) == b.charAt(j-1)){
					dp[i][j] = dp[i-1][j-1] + a.charAt(i-1);
				}else{
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}

				sum = Math.max(sum,dp[i][j]);
			}
		}

		return (as - sum) + (bs - sum);
	}
}
