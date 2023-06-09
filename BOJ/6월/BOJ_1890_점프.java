import java.io.*;
import java.util.*;

public class BOJ_1890_점프 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());

		long[][] dp = new long[N][N];
		dp[0][0] = 1;

		StringTokenizer st;
		int tmp;
		for(int i=0;i<N;i++){
			st = new StringTokenizer(in.readLine());
			for(int j=0;j<N;j++){
				tmp = Integer.parseInt(st.nextToken());
				if(dp[i][j] == 0 || tmp==0) continue;
				if(j+tmp < N) dp[i][j+tmp] += dp[i][j];
				if(i+tmp < N) dp[i+tmp][j] += dp[i][j];
			}
		}

		System.out.println(dp[N-1][N-1]);
	}
}
