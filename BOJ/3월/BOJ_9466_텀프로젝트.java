import java.io.*;
import java.util.*;

public class BOJ_9466_텀프로젝트 {
	static int N,count;
	static int[] input;
	static boolean[] visited,done;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		for (int tc = 0; tc < T; tc++) {
			N = Integer.parseInt(in.readLine());

			input = new int[N+1];
			visited = new boolean[N+1];
			done = new boolean[N+1];

			st = new StringTokenizer(in.readLine());
			for(int i=1;i<=N;i++) input[i] = Integer.parseInt(st.nextToken());

			count = 0;
			for(int i=1;i<=N;i++){
				if(!visited[i]) dfs(i);
			}

			sb.append(N-count).append('\n');

		}

		System.out.print(sb);

	}

	public static void dfs(int now) {
		visited[now] = true;
		int next = input[now];
		if(!visited[next]) {//아예 방문한 적 없다면
			dfs(next);
		}else if(!done[next]){//이전에 방문한 적 있지만 팀매칭 끝나지 않았다면(=next부터 사이클 있는 것)
			for(int i=next;i!=now;i=input[i]) count++;
			count++;
		}
		done[now] = true;
	}

}