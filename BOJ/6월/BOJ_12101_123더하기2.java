import java.io.*;
import java.util.*;

public class BOJ_12101_123더하기2 {
	static StringBuilder sb = new StringBuilder();
	static int[] dp = new int[11];
	public static void main(String[] args) throws IOException {
		dp[0] = 1; dp[1] = 1; dp[2] = 2; dp[3] = 4;
		for(int i=4;i<11;i++) dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
		StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		//만약 k가 dp[n]보다 크다면 -1
		if(dp[N]<K){
			System.out.println(-1);
			return;
		}

		find(N,K);
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
	public static void find(int n, int k){
		for(int i=1;i<=3;i++){
			if(n-i<0) break;
			if(dp[n-i] >= k){
				sb.append(i).append('+');
				find(n-i,k);
				break;
			}
			k-=dp[n-i];
		}
	}
}
