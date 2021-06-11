import java.io.*;
import java.util.*;

public class Main{
	static int[][] study;
	static int[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		
		study = new int[n+1][2];
		dp = new int[t+1];
		
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			study[i][0] = Integer.parseInt(st.nextToken());
			study[i][1] = Integer.parseInt(st.nextToken());
		}
		
		br.close();
		
		for(int[] chapter:study) {
			for(int j=t;j>=chapter[0];j--) {
				dp[j] = Math.max(dp[j], dp[j-chapter[0]]+chapter[1]);
			}
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(dp[t]));
		
		bw.flush();
		bw.close();
	}
}