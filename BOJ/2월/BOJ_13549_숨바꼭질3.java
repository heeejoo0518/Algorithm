import java.io.*;
import java.util.*;

public class BOJ_13549_숨바꼭질3 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int INF = 200001;

		int[] dist = new int[INF];
		boolean[] visited = new boolean[INF];

		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[]{N,0});

		int idx, value;
		while(!queue.isEmpty()){
			idx = queue.peek()[0];
			value = queue.poll()[1];

			if(visited[idx]) continue;

			visited[idx] = true;
			dist[idx] = value;

			if(idx==K) break;

			if(idx*2<INF && !visited[idx*2]) queue.offer(new int[]{idx*2,value});
			if(idx-1>=0 && !visited[idx-1]) queue.offer(new int[]{idx-1,value+1});
			if(idx+1<INF && !visited[idx+1]) queue.offer(new int[]{idx+1, value+1});
		}

		System.out.println(dist[K]);

	}
}
