import java.io.*;
import java.util.*;

public class BOJ_16928_뱀과사다리게임 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] info = new int[101];
		for(int i=0;i<N+M;i++){
			st = new StringTokenizer(in.readLine());
			info[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}

		int[] dist = new int[101];
		dist[1] = 1;
		Deque<Integer> deque = new ArrayDeque<>();
		deque.offer(1);

		int num;
		while(!deque.isEmpty()){
			num = deque.poll();

			if(info[num] != 0){
				if(dist[info[num]] != 0 && dist[info[num]] <= dist[num]) continue;
				deque.offerFirst(info[num]);
				dist[info[num]] = dist[num];
				continue;
			}

			for(int next=num+1;next<=num+6 && next<=100;next++){
				if(dist[next]!=0) continue;
				deque.offer(next);
				dist[next] = dist[num]+1;
			}
		}

		System.out.println(dist[100]-1);
	}
}
