import java.io.*;
import java.util.*;

public class BOJ_1107_리모컨 {
	static int[] dp;
	static boolean[] remote;
	static int INF = 1_000_000;
	static int diff = INF;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		int M = Integer.parseInt(in.readLine());
		remote = new boolean[10];
		dp = new int[INF];
		Arrays.fill(dp,INF);
		if(M !=0){
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int i=0;i<M;i++) remote[Integer.parseInt(st.nextToken())] = true;
		}

		find(0,0);
		dp[100] = 0;
		int answer = diff;
		if(N+diff < INF) answer += N >= diff ? Math.min(dp[N+diff],dp[N-diff]):dp[N+diff];
		answer = Math.min(answer, Math.abs(100-N));
		System.out.println(answer);
	}
	public static void find(int cnt, int num) {
		if(cnt>=6){
			return;
		}

		int next;
		for(int i=0;i<10;i++){
			next = num*10+i;
			if(remote[i] || dp[next] != INF) continue;
			dp[next] = cnt+1;
			diff = Math.min(diff, Math.abs(N-next));
			if(next!=0) find(cnt+1, next);
		}
	}
}
