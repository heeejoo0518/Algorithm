import java.io.*;
import java.util.*;

public class Main{
	static int[][] bags;	//0:무게W, 1:가치V
	static int[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		bags = new int[n+1][2];
		dp = new int[k+1];
		
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			bags[i][0] = Integer.parseInt(st.nextToken());
			bags[i][1] = Integer.parseInt(st.nextToken());
		}
		
		br.close();
		
		for(int i=1;i<=n;i++) {
			int w = bags[i][0];
			int v = bags[i][1];
			for(int j=k;j>=w;j--) {
				dp[j] = Math.max(dp[j], dp[j-w]+v);
			}
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(dp[k]));
		
		bw.flush();
		bw.close();
	}
}