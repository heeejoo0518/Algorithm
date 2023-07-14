import java.io.*;
import java.util.*;

public class BOJ_1238_파티 {
	static int N, X;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());//마을 수
		int M = Integer.parseInt(st.nextToken());//도로 수
		X = Integer.parseInt(st.nextToken());//목적지

		Map<Integer, ArrayList<int[]>> forward = new HashMap<>();
		Map<Integer, ArrayList<int[]>> reverse = new HashMap<>();

		int from, to, time;
		ArrayList<int[]> val;
		for(int i=0;i<M;i++){
			st = new StringTokenizer(in.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			time = Integer.parseInt(st.nextToken());

			val = forward.getOrDefault(from, new ArrayList<>());
			val.add(new int[]{to,time});
			forward.put(from, val);

			val = reverse.getOrDefault(to, new ArrayList<>());
			val.add(new int[]{from, time});
			reverse.put(to, val);
		}

		int[] f = dijkstra(forward);
		int[] r = dijkstra(reverse);

		int max=0;
		for(int i=1;i<=N;i++){
			if(i==X) continue;
			if(f[i] + r[i] < max) continue;
			max = f[i] + r[i];
		}

		System.out.println(max);
	}

	private static int[] dijkstra(Map<Integer, ArrayList<int[]>> roads){
		int INF = 100_001;//1000개 마을 x 시간 최대 100 + 1
		int[] dist = new int[N+1];
		boolean[] visited = new boolean[N+1];
		Arrays.fill(dist, INF);

		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->o1[1]-o2[1]);
		pq.offer(new int[]{X,0});
		dist[X] = 0;

		int[] now;
		while(!pq.isEmpty()){
			now = pq.poll();
			if(visited[now[0]]) continue;
			visited[now[0]] = true;
			dist[now[0]] = now[1];

			for(int[] road:roads.get(now[0])){
				if(visited[road[0]] || dist[road[0]] <= road[1]+now[1]) continue;
				dist[road[0]] = road[1] + now[1];
				pq.offer(new int[]{road[0], dist[road[0]]});
			}
		}

		return dist;
	}
}
