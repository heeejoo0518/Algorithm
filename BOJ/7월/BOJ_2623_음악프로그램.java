import java.io.*;
import java.util.*;

public class BOJ_2623_음악프로그램 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		boolean[][] order = new boolean[N+1][N+1];
		int[] count = new int[N+1];

		int prev, now, m;
		for(int i=0;i<M;i++){
			st = new StringTokenizer(in.readLine());
			m = Integer.parseInt(st.nextToken());
			prev = 0;
			for(int j=0;j<m;j++){
				now = Integer.parseInt(st.nextToken());
				if(prev != 0 && !order[prev][now]) {
					count[now]++;
					order[prev][now] = true;
				}
				prev = now;
			}
		}

		Queue<Integer> queue = new ArrayDeque<>();
		for(int i=1;i<=N;i++) {
			if(count[i]==0) queue.offer(i);
		}

		ArrayList<Integer> answer = new ArrayList<>();
		while(!queue.isEmpty()){
			now = queue.poll();
			answer.add(now);

			for(int i=1;i<=N;i++){
				if(order[now][i]){
					if(--count[i]==0) queue.offer(i);
				}
			}
		}

		if(answer.size()!=N) {
			System.out.println(0);
			return;
		}

		StringBuilder sb = new StringBuilder();
		for(int ans:answer) sb.append(ans).append('\n');
		System.out.print(sb);
	}
}
