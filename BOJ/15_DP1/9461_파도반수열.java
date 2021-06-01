import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main{
	static long[] dp = new long[102];
	public static void main(String[] args) throws IOException {
		dp[1] = 1; dp[2] = 1; dp[3] = 1;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int t = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		while(t-->0) {
			sb.append(wave(Integer.parseInt(br.readLine()))+"\n");
		}
		br.close();
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());		
		bw.flush();
		bw.close();
	}
	
	public static long wave(int n) {
		if(n<=3) return 1;
		if(dp[n]!=0) return dp[n];
		dp[n] = wave(n-2)+wave(n-3);
		return dp[n];
	}
}