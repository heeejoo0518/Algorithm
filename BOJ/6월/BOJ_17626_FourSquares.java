import java.io.*;

public class BOJ_17626_FourSquares {
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		int[] dp = new int[N+1];
		for(int i=1;i<=Math.sqrt(N);i++) dp[i*i] = 1;
		for(int i=1;i<=N;i++){
			if(dp[i]!=0) continue;
			dp[i] = dp[i-1]+1;
			for(int j=2;j<=Math.sqrt(i);j++){
				dp[i] = Math.min(dp[i], dp[i-j*j]+1);
			}
		}

		System.out.println(dp[N]);
	}
}
