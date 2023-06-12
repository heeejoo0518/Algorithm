import java.io.*;
import java.util.*;

public class BOJ_12852_1로만들기2 {
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());

		int[] dp = new int[N+1];
		dp[1] = 0;
		for(int i=2;i<N;i++){
			dp[i] = dp[i-1]+1;
			if(i%3==0) dp[i] = Math.min(dp[i], dp[i/3]+1);
			if(i%2==0) dp[i] = Math.min(dp[i], dp[i/2]+1);
		}

		StringBuilder sb = new StringBuilder();
		sb.append(dp[N]).append('\n').append(N).append(' ');
		int num = N;
		while(num!=1){
			if(num%3==0 && dp[num/3]==dp[num]-1) num = num/3;
			else if(num%2==0 && dp[num/2]==dp[num]-1) num = num/2;
			else num = num-1;
			sb.append(num).append(' ');
		}

		System.out.print(sb);
	}
}
