import java.io.*;
import java.util.*;

public class Main{
	static int[] paper;
	static int[] sum;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			int k = Integer.parseInt(br.readLine());
			paper = new int[k];
			sum = new int[k+1];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<k;i++) {
				paper[i] = Integer.parseInt(st.nextToken());
				sum[i+1] = sum[i]+paper[i];
			}
			
			dp = new int[k+1][k+1];
			
			for(int page=1;page<=k;page++) {
				for(int index=1;index+page<=k;index++) {
					dp[index][index+page] = Integer.MAX_VALUE;
					for(int mid=index;mid<index+page;mid++) {
						dp[index][index+page] = Math.min(dp[index][index+page], dp[index][mid]+dp[mid+1][index+page] + sum[index+page] - sum[index-1]);
					}
				}
			}
			
			sb.append(dp[1][k]+"\n");
		}
		
		br.close();
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}