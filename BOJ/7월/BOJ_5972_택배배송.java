import java.io.*;
import java.util.*;

public class BOJ_5972_택배배송 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Node[] road = new Node[N+1];
		int a, b, c;
		for(int m=0;m<M;m++){
			st = new StringTokenizer(in.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			road[a] = new Node(b,c,road[a]);
			road[b] = new Node(a,c,road[b]);
		}

		System.out.println(dijkstra(N,road));
	}

	private static int dijkstra(int N, Node[] road){
		boolean[] visited = new boolean[N+1];
		int[] count = new int[N+1];
		Arrays.fill(count,50_000_001);
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->o1[1]-o2[1]);
		pq.offer(new int[]{1,0});

		int[] now;
		while(!pq.isEmpty()){
			now = pq.poll();
			if(visited[now[0]]) continue;
			visited[now[0]] = true;
			count[now[0]] = now[1];

			for(Node r=road[now[0]];r!=null;r = r.next){
				if(count[r.to] > now[1] + r.cow){
					count[r.to] = now[1] + r.cow;
					pq.offer(new int[]{r.to, count[r.to]});
				}
			}
		}

		return count[N];
	}

	private static class Node {
		int to, cow;
		Node next;
		Node(int to, int cow, Node next){
			this.to = to;
			this.cow = cow;
			this.next = next;
		}
	}
}
