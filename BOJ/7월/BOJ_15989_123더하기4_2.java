import java.io.*;

public class BOJ_15989_123더하기4_2 {
	public static void main(String[] args) throws IOException {
		int[][] dp = new int[10001][4];
		dp[1][1] = dp[2][1] = dp[2][2] = dp[3][1] = dp[3][2] = dp[3][3] = 1;
		for(int i=4;i<10001;i++) {
			dp[i][1] = dp[i-1][1];
			dp[i][2] = dp[i-2][1]+dp[i-2][2];
			dp[i][3] = dp[i-3][1]+dp[i-3][2]+dp[i-3][3];
		}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=0;tc<T;tc++){
			int num = Integer.parseInt(in.readLine());
			sb.append(dp[num][1]+dp[num][2]+dp[num][3]).append('\n');
		}
		System.out.print(sb);
	}
}
