import java.io.*;
import java.util.*;

public class BOJ_1197_최소스패닝트리 {
	static int[] root;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		root = new int[V+1];
		for(int i=1;i<=V;i++) root[i] = i;

		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->o1[2]-o2[2]);
		int a,b,c;
		for(int i=0;i<E;i++){
			st = new StringTokenizer(in.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			pq.offer(new int[]{a,b,c});
		}

		int answer = 0;
		while(!pq.isEmpty()){
			a = find(pq.peek()[0]);
			b = find(pq.peek()[1]);
			c = pq.poll()[2];

			if(a == b) continue;

			union(a,b);
			answer += c;
		}

		System.out.println(answer);
	}

	private static int find(int x){
		if(root[x]==x) return x;
		return root[x] = find(root[x]);
	}

	private static void union(int a,int b){
		int ra = find(a);
		int rb = find(b);
		if(ra==rb) return;

		root[ra] = rb;
	}
}
