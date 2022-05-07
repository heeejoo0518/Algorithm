import java.io.*;
import java.util.*;

public class Main{
	static int[] A;
	static int[][] dp; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int n = Integer.parseInt(br.readLine());
		
		A = new int[n+1];
		dp = new int[n+1][2];
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=1;i<=n;i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		br.close();
		
		subsequence(n);
		
		int max = 0;
		for(int i=1;i<n+1;i++) {
			int sum = dp[i][0]+dp[i][1];
			if(max<sum) max = sum;
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(max-1+""); //자기자신 중복 1 뺌
		bw.flush();
		bw.close();
	}
	
	public static void subsequence(int n) {
		if(n<1) return;
		if(dp[n][0]!=0) return;
		
		int len = dp.length;
		
		if(n==1) {
			dp[n][0] = 1;
			dp[len-1][1] = 1; 
			return;
		}
		
		//재귀
		subsequence(n-1);
		
		//앞에서 증가하는 부분수열
		dp[n][0] = 1;
		for(int i=1;i<n;i++) {
			if(dp[n][0]<=dp[i][0] && A[n] > A[i]) {
				dp[n][0] = dp[i][0] + 1;
			}
		}
		
		//뒤에서 감소하는 부분수열
		dp[len-n][1] = 1;
		for(int i=len-n+1;i<dp.length;i++) {
			if(dp[len-n][1]<=dp[i][1] && A[len-n]>A[i]) {
				dp[len-n][1] = dp[i][1]+1;
			}
		}
		
		return;
		
	}
}