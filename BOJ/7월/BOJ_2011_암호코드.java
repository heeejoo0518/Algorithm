import java.io.*;

public class BOJ_2011_암호코드 {
	public static void main(String[] args) throws IOException {
		char[] password = new BufferedReader(new InputStreamReader(System.in)).readLine().toCharArray();
		int N = password.length;
		int MOD = 1000000;
		int[][] dp = new int[N][2];

		if(password[0]-'0' > 0) dp[0][0] = 1;
		for(int i=1;i<N;i++){
			if(password[i]-'0'> 0) dp[i][0] = (dp[i-1][0] + dp[i-1][1])%MOD;
			if((password[i-1]-'0')*10 + password[i]-'0' <= 26) dp[i][1] = dp[i-1][0];
		}

		System.out.println((dp[N-1][0] + dp[N-1][1])%MOD);
	}
}
