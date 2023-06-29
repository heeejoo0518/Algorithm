import java.io.*;
import java.util.*;

public class BOJ_5557_1학년 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] number = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=0;i<N;i++) number[i] = Integer.parseInt(st.nextToken());

		long[][] dp = new long[N][21];
		dp[0][number[0]] = 1;
		for(int idx=1;idx<N-1;idx++){
			for(int num=0;num<21;num++){//이전값
				if(dp[idx-1][num]==0) continue;
				if(num+number[idx] < 21) dp[idx][num+number[idx]] += dp[idx-1][num];
				if(num-number[idx] > -1) dp[idx][num-number[idx]] += dp[idx-1][num];
			}
		}

		System.out.println(dp[N-2][number[N-1]]);
	}

}
