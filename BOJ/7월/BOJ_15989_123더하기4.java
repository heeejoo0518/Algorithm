import java.io.*;

public class BOJ_15989_123더하기4 {
	public static void main(String[] args) throws IOException {
		int[] dp = new int[10001];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;
		for(int i=4;i<10001;i++) dp[i] = 1+i/2+dp[i-3];
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=0;tc<T;tc++){
			sb.append(dp[Integer.parseInt(in.readLine())]).append('\n');
		}
		System.out.print(sb);
	}
}
