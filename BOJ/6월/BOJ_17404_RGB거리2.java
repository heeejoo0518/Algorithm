import java.io.*;
import java.util.*;

public class BOJ_17404_RGB거리2 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[][] price = new int[N][3];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			price[i][0] = Integer.parseInt(st.nextToken());//red
			price[i][1] = Integer.parseInt(st.nextToken());//green
			price[i][2] = Integer.parseInt(st.nextToken());//blue
		}

		int INF = 1_000_001;
		int answer = INF;
		int[][] dp = new int[N][3];
		for(int color=0;color<3;color++){//첫번째 집 색상
			for(int idx=0;idx<3;idx++) dp[0][idx] = idx==color?price[0][color]:INF;

			for (int i = 1; i < N; i++){
				dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2])+price[i][0];
				dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2])+price[i][1];
				dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1])+price[i][2];
			}

			for(int idx=0;idx<3;idx++) {
				if(idx == color) continue;
				answer = Math.min(answer,dp[N-1][idx]);
			}
		}

		System.out.println(answer);
	}
}
