import java.io.*;
import java.util.*;

public class BOJ_11779_최소비용구하기2 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(in.readLine());
		int M = Integer.parseInt(in.readLine());
		Node[] bus = new Node[N + 1];

		int from, to, cost;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			cost = Integer.parseInt(st.nextToken());
			bus[from] = new Node(to, cost, bus[from]);
		}

		st = new StringTokenizer(in.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		System.out.println(dijkstra(N, start, end, bus));
	}

	private static String dijkstra(int N, int start, int end, Node[] edges) {
		int INF = 100_000_001;//도시 개수 1,000 * 버스 비용 100,000

		int[] dist = new int[N + 1];
		boolean[] visited = new boolean[N + 1];
		Arrays.fill(dist, INF);
		dist[start] = 0;

		PriorityQueue<Route> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
		pq.offer(new Route(start,1,0,null));

		Route now;
		while (!pq.isEmpty()) {
			now = pq.poll();
			if (visited[now.city]) continue;
			visited[now.city] = true;
			dist[now.city] = now.cost;

			if(now.city==end){
				return getResult(now);
			}

			for (Node node = edges[now.city]; node != null; node = node.next) {
				if (dist[node.to] <= node.cost + now.cost) continue;
				dist[node.to] = node.cost + now.cost;
				pq.offer(new Route(node.to,now.count+1, dist[node.to], now));
			}
		}

		return "";
	}

	private static String getResult(Route now) {
		StringBuilder res = new StringBuilder();
		res.append(now.cost).append('\n');
		res.append(now.count).append('\n');

		int[] tmp = new int[now.count];
		for(int i=tmp.length-1;i>=0;i--){
			tmp[i] = now.city;
			now = now.next;
		}

		for (int j : tmp) res.append(j).append(' ');

		return res.toString();
	}

	private static class Node {
		int to, cost;
		Node next;

		Node(int to, int cost, Node next) {
			this.to = to;
			this.cost = cost;
			this.next = next;
		}
	}

	private static class Route {
		int count, city, cost;
		Route next;
		Route(int city, int count, int cost, Route next){
			this.city = city;
			this.count = count;
			this.cost = cost;
			this.next = next;
		}
	}
}
