import java.io.*;
import java.util.*;

public class Main{
	static int[][] dp;
	static char[] t;
	static char[] s;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		
		t = br.readLine().toCharArray();
		s = br.readLine().toCharArray();
		
		br.close();
		
		int m=t.length;
		int n=s.length;
		
		dp = new int[m+1][n+1];
		
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
		
		StringBuilder sb = new StringBuilder();
		
		int i=m;
		int j=n;
		while(i>0 && j>0) {
			if(t[i-1]==s[j-1]) {
				sb.insert(0,t[i-1]);
				i--;j--;
			} else if(dp[i][j-1]>dp[i-1][j]) j--;
			else i--;
		}
		
		sb.insert(0, dp[m][n]+"\n");
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		
		bw.flush();
		bw.close();
	}
}