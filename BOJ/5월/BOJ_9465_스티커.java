import java.io.*;
import java.util.*;

public class BOJ_9465_스티커 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();

		int N;
		int[][] dp;
		StringTokenizer st;
		for(int tc=0;tc<T;tc++){
			N = Integer.parseInt(in.readLine());
			dp = new int[2][N+1];
			for(int i=0;i<2;i++){
				st = new StringTokenizer(in.readLine());
				for(int j=1;j<=N;j++){
					dp[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for(int j=2;j<=N;j++){
				dp[0][j] += Math.max(dp[1][j-1], dp[1][j-2]);
				dp[1][j] += Math.max(dp[0][j-1], dp[0][j-2]);
			}

			sb.append(Math.max(dp[0][N], dp[1][N])).append('\n');
		}
		System.out.print(sb);
	}
}
