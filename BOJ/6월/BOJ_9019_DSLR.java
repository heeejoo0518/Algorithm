import java.io.*;
import java.util.*;

public class BOJ_9019_DSLR {
	static int[] dp;
	static int MAX = 10000;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=0;tc<T;tc++){
			StringTokenizer st = new StringTokenizer(in.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			count(A,B);
			sb.append(find(B));

		}
		System.out.print(sb);
	}

	public static void count(int A, int B){
		//dp구하기
		dp = new int[MAX];
		Arrays.fill(dp,10001);
		dp[A] = 0;
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(A);

		int num, next;
		while(!queue.isEmpty()){
			num = queue.poll();
			if(num==B) break;

			for(int i=0;i<4;i++){
				//DSLR순서
				if(i==0) next = (num*2) % MAX;
				else if(i==1) next = (num+ MAX -1)% MAX;
				else if(i==2) next = (num%1000)*10 + num/1000;
				else next = (num%10)*1000 + (num/10);

				if(next >= 0 && next < MAX && dp[next] == MAX+1){
					dp[next] = dp[num]+1;
					queue.offer(next);
				}
			}

		}
	}

	public static String find(int B){
		//끝에서부터 1 차이 나는 걸로 알아내기
		char[] comm = {'D','D','S','R','L'};
		char[] answer = new char[dp[B]];
		int num = B, next;
		for(int idx=0;idx<dp[B];idx++){
			//4가지 경우 찾고 저장, DDS"RL"순서
			for(int i=0;i<5;i++){
				if(i==0 && num%2 == 0) next = (num/2)% MAX;
				else if(i == 1 && num%2 == 0) next = (num+10000)/2%MAX;
				else if(i==2) next = (num+1)% MAX;
				else if(i==3) next = (num%1000)*10 + num/1000;
				else if(i==4) next = (num%10)*1000 + (num/10);
				else continue;

				if(next < MAX && dp[next] == dp[num]-1){
					num = next;
					answer[idx] = comm[i];
					break;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for(int i=dp[B]-1;i>=0;i--){
			sb.append(answer[i]);
		}

		return sb.append('\n').toString();
	}
}
