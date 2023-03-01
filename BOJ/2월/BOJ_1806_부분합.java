import java.io.*;
import java.util.*;

public class BOJ_1806_부분합 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());

		int[] dp = new int[N+1];
		st = new StringTokenizer(in.readLine());
		dp[1] = Integer.parseInt(st.nextToken());

		for (int i = 2; i <= N; i++) {
			dp[i] = dp[i - 1] + Integer.parseInt(st.nextToken());
		}

		int answer = N+1;
		int left = 1,right = 1;
		while(right<=N){
			if(left>N) break;
			if(dp[right]-dp[left-1] >= S){
				answer = Math.min(answer, right-left+1);
				left++;
			}
			else right++;
		}

		System.out.println(answer==N+1?0:answer);

	}
}
