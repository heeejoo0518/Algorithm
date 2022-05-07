import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11724_연결요소의개수4 {
	static int[][] adjMatrix;
	static boolean[] visited;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		adjMatrix = new int[N+1][N+1];

		for(int i=0;i<M;i++){
			st = new StringTokenizer(in.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			adjMatrix[u][v] = 1;
			adjMatrix[v][u] = 1;
		}

		visited = new boolean[N+1];
		int count = 0;
		for(int i=1;i<=N;i++) {
			if (visited[i]) continue;
			visited[i] = true;
			dfs(i);
			count++;
		}

		System.out.println(count);
	}

	private static void dfs(int num) {
		for(int i=1;i<=N;i++){
			if(visited[i] || adjMatrix[num][i] != 1) continue;
			visited[i] = true;
			dfs(i);
		}
	}
}
