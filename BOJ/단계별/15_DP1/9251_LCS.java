import java.io.*;

public class Main{
	static int[][] dp;
	static char[] t;
	static char[] s;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		
		t = br.readLine().toCharArray();
		s = br.readLine().toCharArray();
		
		br.close();

		dp = new int[t.length+1][s.length+1];
		
//		checkLCS(t.length,s.length);
		int m = t.length;
		int n = s.length;
		for(int i=1;i<=m;i++) {
			for(int j=1;j<=n;j++) {
				if(t[i-1]==s[j-1]) {
					dp[i][j] = dp[i-1][j-1]+1;
				}
				else {
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
				}
				
			}
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(dp[m][n]+"");
		
		bw.flush();
		bw.close();
	}
	
//	public static int checkLCS(int m, int n) {
//		if(dp[m][n]!=0) return dp[m][n];
//		if(m==0 || n==0) return dp[m][n];
//		
//		if(t[m-1]==s[n-1]) {
//			dp[m][n] = checkLCS(m-1,n-1)+1;
//		}
//		else {
//			dp[m][n] = Math.max(checkLCS(m,n-1), checkLCS(m-1,n));
//		}
//		
//		return dp[m][n];
//	}
}