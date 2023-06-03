import java.io.*;

public class BOJ_5582_공통부분문자열 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		char[] A = in.readLine().toCharArray();
		char[] B = in.readLine().toCharArray();
		int[][] dp = new int[A.length+1][B.length+1];

		int answer = 0;
		for(int i=1;i<=A.length;i++){
			for(int j=1;j<=B.length;j++){
				if(A[i-1] != B[j-1]) continue;
				dp[i][j] = dp[i-1][j-1]+1;
				answer = Math.max(answer, dp[i][j]);
			}
		}

		System.out.println(answer);
	}
}
