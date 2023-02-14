import java.io.*;
import java.util.*;

public class BOJ_10971_외판원순회2 {
	static int[][] W,dp;
	static int N,LAST;
	static int MAX = 10000001;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());

		W = new int[N][N];
		dp = new int[N][1<<N];
		LAST = (1<<N)-1;

		StringTokenizer st;
		for(int i=0;i<N;i++){
			st = new StringTokenizer(in.readLine());
			for(int j=0;j<N;j++){
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(travel(0,1));
	}

	public static int travel(int city, int visited){
		if(visited==LAST){
			//처음으로 돌아갈 수 있을때만 정상적인 비용 계산
			if(W[city][0] != 0) return W[city][0];
			return MAX;
		}

		//이미 값 있을 때(방문완료)
		if(dp[city][visited] != 0) return dp[city][visited];

		dp[city][visited] = MAX;
		for(int i=0;i<N;i++){
			//길 없으면 | 이미 방문했다면 넘김
			if(W[city][i]==0 || (visited&1<<i)!=0) continue;

			dp[city][visited] = Math.min(dp[city][visited],W[city][i]+travel(i,visited|1<<i));
		}

		return dp[city][visited];
	}
}
