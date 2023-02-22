import java.io.*;
import java.util.*;

public class BOJ_1916_최소비용구하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int M = Integer.parseInt(in.readLine());
		int[][] fee = new int[N + 1][N + 1];
		int INF = 100000001;

		for (int i = 1; i <= N; i++) {
			Arrays.fill(fee[i], INF);
		}

		StringTokenizer st;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			fee[start][end] = Math.min(fee[start][end],cost);
		}

		st = new StringTokenizer(in.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		int[] dist = new int[N + 1];
		Arrays.fill(dist, INF);
		dist[A] = 0;

		boolean[] visited = new boolean[N + 1];
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		pq.offer(new int[]{A, dist[A]});


		int[] now;
		while (!pq.isEmpty()) {
			now = pq.poll();
			if (visited[now[0]]) continue;
			visited[now[0]] = true;
			dist[now[0]] = now[1];
			if (now[0] == B) {
				break;
			}

			for (int i = 1; i <= N; i++) {
				if (visited[i] || fee[now[0]][i] < 0) continue;
				if (dist[i] > now[1] + fee[now[0]][i]) {
					dist[i] = now[1]+fee[now[0]][i];
					pq.offer(new int[]{i, dist[i]});
				}
			}
		}
		System.out.println(dist[B]);

	}
}
