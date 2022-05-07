import java.io.*;
import java.util.*;

public class Main{
	static int[] coins;
	static int[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int t = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		while(t-->0) {
			int n = Integer.parseInt(br.readLine());
			coins = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			int m = Integer.parseInt(br.readLine());
			dp = new int[m+1];
			dp[0] = 1;
			
			for(int i=0;i<n;i++) {
				int coin = coins[i];
				for(int j=coin;j<=m;j++) {
					dp[j] += dp[j-coin];
				}
//				for(int j=m;j>=coin;j--) {
//					int sum = j%coin==0?1:0;
//					for(int k=j;k>0;k-=coin) {
//						sum += dp[k];
//					}
//					dp[j] = sum;
//				}
			}
			
			sb.append(dp[m]+"\n");
		}
		br.close();

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		
		bw.flush();
		bw.close();
	}
}