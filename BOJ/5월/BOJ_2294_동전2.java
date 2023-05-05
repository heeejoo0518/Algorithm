import java.io.*;
import java.util.*;

public class BOJ_2294_동전2 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] coins = new int[N];
		for(int i=0;i<N;i++) {
			coins[i] = Integer.parseInt(in.readLine());
		}

		int[] dp = new int[K+1];
		Arrays.fill(dp, 10001);
		dp[0] = 0;

		for(int coin:coins){
			for(int i=coin;i<=K;i++) dp[i] = Math.min(dp[i], dp[i-coin]+1);
		}

		if(dp[K] < 10001) System.out.println(dp[K]);
		else System.out.println(-1);
	}
}
