import java.io.*;
import java.util.*;

public class BOJ_1937_욕심쟁이판다 {
	static int[][] info, dp;
	static int N;
	static int[][] deltas = {{1,0},{0,1},{0,-1},{-1,0}};
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		info = new int[N][N];
		StringTokenizer st;
		for(int i=0;i<N;i++){
			st = new StringTokenizer(in.readLine());
			for(int j=0;j<N;j++){
				info[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp = new int[N][N];
		int MAX = 0;
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				dp[i][j] = dfs(i,j);
				MAX = Math.max(MAX, dp[i][j]);
			}
		}

		System.out.println(MAX);
	}

	private static int dfs(int i, int j){
		if(dp[i][j]!=0) return dp[i][j];

		int ni,nj, max = 0;
		for(int[] d:deltas){
			ni = i+d[0];
			nj = j+d[1];
			if(ni<0||nj<0||ni>=N||nj>=N||info[ni][nj]<=info[i][j]) continue;
			max = Math.max(max,dfs(ni,nj));
		}
		return dp[i][j] = 1 + max;
	}
}
