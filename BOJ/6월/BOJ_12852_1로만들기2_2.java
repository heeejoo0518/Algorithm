import java.io.*;
import java.util.*;

public class BOJ_12852_1로만들기2_2 {
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());

		int[] dp = new int[N+1];
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(N);
		int num;
		while(!queue.isEmpty()){
			num = queue.poll();
			if(num<=1) break;
			if(num%3==0 && dp[num/3]==0){
				queue.offer(num/3);
				dp[num/3] = dp[num]+1;
			}
			if(num%2==0 && dp[num/2]==0){
				queue.offer(num/2);
				dp[num/2] = dp[num]+1;
			}
			if(dp[num-1]==0){
				queue.offer(num-1);
				dp[num-1] = dp[num]+1;
			}
		}

		//숫자 채우기
		int[] answer = new int[dp[1]+1];
		num = 1;
		answer[dp[1]] = 1;
		for(int i=dp[1]-1;i>=0;i--){
			if(num*3<=N && dp[num*3]==dp[num]-1) num*=3;
			else if(num*2<=N && dp[num*2]==dp[num]-1) num*=2;
			else num+=1;
			answer[i] = num;
		}

		//출력
		StringBuilder sb = new StringBuilder();
		sb.append(dp[1]).append('\n');
		for(int n:answer) sb.append(n).append(' ');

		System.out.println(sb);
	}
}
