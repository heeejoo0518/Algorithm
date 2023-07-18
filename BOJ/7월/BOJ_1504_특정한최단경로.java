import java.io.*;
import java.util.*;

public class BOJ_1504_특정한최단경로 {
	static int N;
	static int INF = 200_000_001;
	static Node[] edges;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		edges = new Node[N + 1];
		int from, to, distance;
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			distance = Integer.parseInt(st.nextToken());
			edges[from] = new Node(to, distance, edges[from]);
			edges[to] = new Node(from, distance, edges[to]);
		}

		st = new StringTokenizer(in.readLine());
		int V1 = Integer.parseInt(st.nextToken());
		int V2 = Integer.parseInt(st.nextToken());

		int case1 = dijkstra(1, V1) + dijkstra(V1, V2) + dijkstra(V2, N);
		int case2 = dijkstra(1, V2) + dijkstra(V2, V1) + dijkstra(V1, N);

		int result = Math.min(case1, case2);
		if(result >= INF) System.out.println(-1);
		else System.out.println(result);
	}

	private static int dijkstra(int start, int end) {
		int[] dist = new int[N + 1];
		boolean[] visited = new boolean[N + 1];
		Arrays.fill(dist, INF);
		dist[start] = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		pq.offer(new int[]{start, 0});

		int[] now;
		while (!pq.isEmpty()) {
			now = pq.poll();
			if (visited[now[0]]) continue;
			visited[now[0]] = true;
			dist[now[0]] = now[1];

			for (Node node = edges[now[0]]; node != null; node = node.next) {
				if (dist[node.to] <= node.dist + now[1]) continue;
				dist[node.to] = node.dist + now[1];
				pq.offer(new int[]{node.to, dist[node.to]});
			}
		}

		return dist[end];
	}

	private static class Node {
		int to, dist;
		Node next;

		Node(int to, int dist, Node next) {
			this.to = to;
			this.dist = dist;
			this.next = next;
		}
	}
}
