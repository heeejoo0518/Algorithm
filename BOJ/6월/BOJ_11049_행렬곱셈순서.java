import java.io.*;
import java.util.*;

public class BOJ_11049_행렬곱셈순서 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[][] arr = new int[N][2];
		StringTokenizer st;
		for(int i=0;i<N;i++){
			st = new StringTokenizer(in.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		int[][] dp = new int[N][N];
		for(int i=0;i<N;i++){
			Arrays.fill(dp[i], Integer.MAX_VALUE);
			dp[i][i] = 0;
		}

		int end;
		for(int len=1;len<N;len++){
			for(int start=0;start<N-len;start++){
				end = start+len;
				int tmp = arr[start][0]*arr[end][1];
				for(int mid = start;mid<end;mid++){
					dp[start][end] = Math.min(dp[start][end],
							dp[start][mid]+dp[mid+1][end]+tmp*arr[mid][1]);
				}
			}
		}

		System.out.println(dp[0][N-1]);
	}
}
