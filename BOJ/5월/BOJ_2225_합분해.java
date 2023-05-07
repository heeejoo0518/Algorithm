import java.io.*;
import java.util.*;

public class BOJ_2225_합분해 {
	public static void main(String[] args) throws IOException {
		int MOD = 1000000000;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		long[][] dp = new long[N+1][K+1];

		for(int k=1;k<=K;k++){
			dp[0][k] = 1;
			for(int n=1;n<=N;n++){
				dp[n][k] = (dp[n-1][k] + dp[n][k-1])%MOD;
			}
		}

		System.out.println(dp[N][K]);
	}
}
