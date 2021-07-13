import java.io.*;
import java.util.*;

public class Main{
	static StringBuilder sb = new StringBuilder();
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());	//정점의 개수
		int m = Integer.parseInt(st.nextToken());	//간선의 개수
		int v = Integer.parseInt(st.nextToken());	//탐색 시작 번호
		
		arr = new int[n+1][n+1];
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x][y] = 1;
			arr[y][x] = 1;
		}
		
		br.close();
		
		dfs(v, new boolean[n+1]);
		sb.append("\n");
		
		bfs(new LinkedList<Integer>(Arrays.asList(v)), new boolean[n+1]);
		
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void dfs(int v, boolean[] visited) {
		visited[v] = true;
		sb.append(v+" ");
		
		for(int i=1;i<visited.length;i++) {
			if(arr[v][i]==1 && !visited[i]) {
				dfs(i,visited);
			}
		}
	}
	
	private static void bfs(Queue<Integer> queue, boolean[] visited) {
		if(queue.isEmpty()) return;
		
		int v = queue.poll();
		visited[v] = true;
		
		sb.append(v+" ");
		
		for(int i=1;i<visited.length;i++) {
			if(arr[v][i]==1 && !visited[i]) {
				queue.offer(i);
				visited[i] = true;
			}
		}
		
		bfs(queue,visited);
	}
}