import java.io.*;
import java.util.*;

public class BOJ_1005_ACMCraft {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int N,K,W;
		int[] enter,time,total;
		for(int tc=0;tc<T;tc++){
			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			time = new int[N+1];
			st = new StringTokenizer(in.readLine());
			for(int i=1;i<=N;i++) time[i] = Integer.parseInt(st.nextToken());

			ArrayList<Integer>[] buildings = new ArrayList[N+1];
			for(int i=1;i<=N;i++) buildings[i] = new ArrayList<>();

			enter = new int[N+1];
			int from, to;
			for(int i=0;i<K;i++){
				st = new StringTokenizer(in.readLine());
				from = Integer.parseInt(st.nextToken());
				to = Integer.parseInt(st.nextToken());
				buildings[from].add(to);
				enter[to]++;
			}

			W = Integer.parseInt(in.readLine());

			total = new int[N+1];

			Queue<Integer> queue = new ArrayDeque<>();
			for(int i=1;i<=N;i++) {
				if(enter[i]==0) {
					queue.offer(i);
					total[i] = time[i];
					enter[i] = -1;
				}
			}

			int now;
			int answer = 0;
			while(!queue.isEmpty()){
				now = queue.poll();
				if(now==W){
					answer = total[now];
					break;
				}

				for(int next:buildings[now]){
					total[next] = Math.max(total[next],total[now]);
					--enter[next];
					if(enter[next]==0){
						queue.offer(next);
						total[next] += time[next];
						enter[next] = -1;
					}

				}

			}
			sb.append(answer).append('\n');
		}

		System.out.print(sb);


	}
}
