import java.io.*;
import java.util.*;

public class BOJ_9527_1의개수세기 {
	static long[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		dp = new long[55];
		dp[0] = 1;
		for(int i=1;i<55; i++) dp[i] = dp[i-1]*2 + (1L<<i);

		System.out.println(countOne(B)-countOne(A-1));
	}

	public static long countOne(long x){
		long ans = x&1;
		for(int cnt = 54;cnt>0;cnt--){
			if((x&(1L<<cnt))!=0){
				x-=1L<<cnt;
				ans += dp[cnt-1] + (x+1);
			}
		}

		return ans;
	}
}
