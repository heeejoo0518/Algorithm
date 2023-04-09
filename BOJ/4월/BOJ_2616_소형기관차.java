import java.io.*;
import java.util.*;

public class BOJ_2616_소형기관차 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] train = new int[N + 1];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 1; i <= N; i++) train[i] = train[i - 1] + Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(in.readLine());//기관차가 최대로 끌 수 있는 객차 수
		int[][] dp = new int[4][N + 1];
		for (int i = 1; i < 4; i++) {
			for (int j = i * M; j <= N; j++) {
				dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j - M] + train[j] - train[j - M]);
			}
		}
		System.out.println(dp[3][N]);

	}
}
