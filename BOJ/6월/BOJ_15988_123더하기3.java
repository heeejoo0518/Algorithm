import java.io.*;

public class BOJ_15988_123더하기3 {
	public static void main(String[] args) throws IOException {
		int MOD = 1_000_000_009;
		int[] dp = new int[1000001];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for(int i=4;i<1000001;i++) dp[i] = ((dp[i-1] + dp[i-2])%MOD + dp[i-3])%MOD;

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=0;tc<T;tc++){
			sb.append(dp[Integer.parseInt(in.readLine())]).append('\n');
		}

		System.out.print(sb);
	}
}
