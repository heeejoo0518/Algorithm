import java.io.*;
import java.util.*;

public class Main{
	static int[] dp;
	static int[] A;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int n = Integer.parseInt(br.readLine());
		
		A = new int[n+1];
		dp = new int[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=1;st.hasMoreTokens();i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		br.close();

		int max = subsequence(n);

		for(int i=1;i<=n;i++) {
			if(max<dp[i]) max = dp[i];
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(max+"");
		
		bw.flush();
		bw.close();
	}
	public static int subsequence(int n) {
		if(n<1) return 0;
		if(dp[n]!=0) return dp[n];
		
		int len = dp.length;
		
		if(n==1) return dp[len-1] = 1;
		
		subsequence(n-1);
		
		dp[len-n] = 1;
		for(int i=len-n+1;i<dp.length;i++) {
			if(dp[len-n]<=dp[i] && A[len-n]>A[i]) {
				dp[len-n] = dp[i]+1;
			}
		}

		return dp[len-n];
	}
}