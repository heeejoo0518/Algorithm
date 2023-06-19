import java.io.*;
import java.util.*;

public class BOJ_14916_거스름돈 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] dp = new int[100_001];
		Arrays.fill(dp, N+1);
		dp[2] = dp[5] = 1;
		dp[4] = 2;
		for(int i=6;i<=N;i++){
			dp[i] = Math.min(dp[i-2], dp[i-5])+1;
		}

		if(dp[N]==N+1) System.out.println(-1);
		else System.out.println(dp[N]);

	}
}
