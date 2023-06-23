import java.io.*;
import java.util.*;

public class BOJ_10942_팰린드롬 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());

		boolean[][] dp = new boolean[N][N];
		for(int i=0;i<N;i++){
			dp[i][i] = true;
			if(i+1<N && arr[i]== arr[i+1]) dp[i][i+1] = true;
		}

		for(int len=2;len<N;len++){
			for(int start=0;start<N-len;start++){
				//시작과 끝점(start+len)이 같고 dp[시작 다음점][끝 이전 점]이 팰린드롬이라면
				//dp[start][start+len]도 팰린드롬
				if(arr[start]==arr[start+len] && dp[start+1][start+len-1]) dp[start][start+len] = true;
			}
		}

		int M = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<M;i++){
			st = new StringTokenizer(in.readLine());
			if(dp[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1]) sb.append("1\n");
			else sb.append("0\n");
		}
		System.out.print(sb);
	}
}
