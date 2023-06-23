import java.io.*;
import java.util.*;

public class BOJ_10942_팰린드롬 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] arr = new int[N+1];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=1;i<=N;i++) arr[i] = Integer.parseInt(st.nextToken());

		boolean[][] dp = new boolean[N+1][N+1];
		for(int i=1;i<=N;i++){
			dp[i][i] = true;
			if(i+1<=N && arr[i]== arr[i+1]) dp[i][i+1] = true;

		}

		for(int i=2;i<N;i++){
			for(int j=1;j<=N-i;j++){
				if(arr[j]==arr[j+i] && dp[j+1][j+i-1]) dp[j][j+i] = true;
			}
		}

		int M = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<M;i++){
			st = new StringTokenizer(in.readLine());
			if(dp[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]) sb.append("1\n");
			else sb.append("0\n");
		}
		System.out.print(sb);
	}
}
