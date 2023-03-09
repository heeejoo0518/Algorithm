import java.io.*;
import java.util.*;

public class BOJ_1865_웜홀 {
	static List<Edge> edges;
	static int N,M,W;
	static int INF = 25000001;
	static String yes = "YES\n", no="NO\n";
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for(int tc = 0;tc<TC;tc++){
			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			edges = new ArrayList<>();
			int from,to,time;
			for(int i=0;i<M+W;i++) {
				st = new StringTokenizer(in.readLine());
				from = Integer.parseInt(st.nextToken());
				to = Integer.parseInt(st.nextToken());
				time = Integer.parseInt(st.nextToken());
				if(i<M) {
					edges.add(new Edge(from,to,time));
					edges.add(new Edge(to,from,time));
				}else {
					edges.add(new Edge(from,to,-time));
				}
			}

			if(isCycle()) sb.append(yes);
			else sb.append(no);
		}

		System.out.print(sb);
	}
	static class Edge {
		int from;
		int to;
		int time;
		Edge(int from, int to, int time){
			this.from = from;
			this.to = to;
			this.time = time;
		}
	}

	public static boolean isCycle(){
		//음의 순환 체크
		int[] dist = new int[N+1];
		Arrays.fill(dist, INF);
		int cur,next,cost;
		for(int i=0;i<N;i++){
			for(Edge edge:edges){
				cur = edge.from;
				next = edge.to;
				cost = edge.time;
				if(dist[next]>dist[cur]+cost){
					dist[next] = dist[cur]+cost;
					if(i==N-1) return true;
				}
			}
		}
		return false;
	}
}
