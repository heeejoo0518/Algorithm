import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11724_연결요소의개수3 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] adjMatrix = new int[N + 1][N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			adjMatrix[u][v] = 1;
			adjMatrix[v][u] = 1;
		}

		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[N + 1];
		int count = 0;

		for (int i = 1; i <= N; i++) {
			if (visited[i]) continue;
			queue.offer(i);
			visited[i] = true;
			count++;

			while (!queue.isEmpty()) {
				int num = queue.poll();
				for (int j = 1; j <= N; j++) {
					if (visited[j] || adjMatrix[num][j] != 1) continue;
					queue.offer(j);
					visited[j] = true;
				}
			}
		}

		System.out.println(count);
	}
}
