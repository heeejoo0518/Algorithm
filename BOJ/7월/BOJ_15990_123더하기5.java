import java.io.*;
import java.util.*;

public class BOJ_15990_123더하기5 {
	public static void main(String[] args) throws IOException {
		int MOD = 1_000_000_009;
		int[][] dp = new int[100001][4];
		dp[1][1] = dp[2][2] = dp[3][3] = 1;
		dp[3][1] = 1;
		dp[3][2] = 1;

		for(int num=4;num<100001;num++){
			dp[num][1] = (dp[num-1][2] + dp[num-1][3])%MOD;
			dp[num][2] = (dp[num-2][1] + dp[num-2][3])%MOD;
			dp[num][3] = (dp[num-3][1] + dp[num-3][2])%MOD;
		}

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		int n;
		for(int tc=0;tc<T;tc++){
			n = Integer.parseInt(in.readLine());
			sb.append(((dp[n][1] +dp[n][2])%MOD+dp[n][3])%MOD).append('\n');
		}

		System.out.print(sb);
	}
}
