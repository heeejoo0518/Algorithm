import java.io.*;
import java.util.*;

public class D4_1251_하나로 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(in.readLine());

		int N;
		int[][] island;
		long[] distance;
		boolean[] visited;
		double E, cost;

		PriorityQueue<Connect> pQueue = new PriorityQueue<>();

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			N = Integer.parseInt(in.readLine());
			island = new int[N][2];

			st = new StringTokenizer(in.readLine());
			for (int n = 0; n < N; n++) island[n][0] = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(in.readLine());
			for (int n = 0; n < N; n++) island[n][1] = Integer.parseInt(st.nextToken());

			E = Double.parseDouble(in.readLine());
			cost = 0;

			visited = new boolean[N];
			distance = new long[N];
			Arrays.fill(distance, Long.MAX_VALUE);
			int idx = 0;

			Connect now = new Connect(idx, 0);
			pQueue.offer(now);

			while (!pQueue.isEmpty()) {
				now = pQueue.poll();
				if (visited[idx = now.idx]) continue;
				visited[idx] = true;
				distance[idx] = now.length;
				cost+= distance[idx];

				for (int i = 0; i < N; i++) {
					if (visited[i]) continue;
					long length = (long) (Math.pow(Math.abs(island[idx][0] - island[i][0]),2) + Math.pow(Math.abs(island[idx][1] - island[i][1]),2));
					if (distance[i] > now.length+length) pQueue.offer(new Connect(i, length));
				}
			}

			//pQueue.clear(); //항상 비어있음
			sb.append(Math.round(cost * E)).append("\n");
		}

		System.out.print(sb);
	}

	static class Connect implements Comparable<Connect> {
		int idx;
		long length;

		private Connect(int idx, long length) {
			this.idx = idx;
			this.length = length;
		}

		@Override
		public int compareTo(Connect o) {
			return Long.valueOf(this.length).compareTo(o.length);
		}
	}
}
