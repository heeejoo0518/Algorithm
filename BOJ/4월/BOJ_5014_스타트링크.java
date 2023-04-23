import java.io.*;
import java.util.*;

public class BOJ_5014_스타트링크 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int F = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int U = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		boolean[] visited = new boolean[F+1];
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[]{S,0});
		int[] node;
		int u,d;
		while(!queue.isEmpty()){
			node = queue.poll();
			if(node[0]==G){
				System.out.println(node[1]);
				return;
			}
			u = node[0] + U;
			d = node[0] - D;
			if(u<=F && !visited[u]){
				visited[u] = true;
				queue.offer(new int[]{u,node[1]+1});
			}
			if(d>0 && !visited[d]){
				visited[d] = true;
				queue.offer(new int[]{d,node[1]+1});
			}

		}
		System.out.println("use the stairs");
	}
}
