import java.io.*;
import java.util.*;

public class Main{
	static int[][] network;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		network = new int[n+1][n+1];
		for(int i=0;i<m;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			network[x][y] = 1;
			network[y][x] = 1;
		}
		
		br.close();
		
		bw.write(String.valueOf(bfs(new LinkedList<>(Arrays.asList(1)), new boolean[n+1])));
		bw.flush();
		bw.close();
	}

	private static int bfs(Queue<Integer> queue, boolean[] visited) {
		if(queue.isEmpty()) return -1; //1번 컴퓨터를 계산에서 뺌
		
		int v = queue.poll();
		visited[v] = true;
		
		for(int i=1;i<visited.length;i++) {
			if(network[v][i]==1 && !visited[i]) {
				queue.offer(i);
				visited[i] = true;
			}
		}
		
		return bfs(queue,visited)+1;
	}
	
	
}