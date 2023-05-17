import java.io.*;
import java.util.*;

public class BOJ_11657_타임머신 {
	static long INF = 6000*10000*500L+1;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		ArrayList<Line> lines = new ArrayList<>();
		for(int i=0;i<M;i++){
			st = new StringTokenizer(in.readLine());
			lines.add(new Line(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}

		long[] dist = BellmanFord(N,lines);
		if(dist==null) {
			System.out.println(-1);
			return;
		}

		StringBuilder sb = new StringBuilder();
		for(int i=2;i<=N;i++){
			if(dist[i] != INF) sb.append(dist[i]).append('\n');
			else sb.append("-1\n");
		}

		System.out.print(sb);
	}

	private static long[] BellmanFord(int N, ArrayList<Line> lines){
		long[] dist = new long[N+1];
		Arrays.fill(dist, INF);
		dist[1] = 0;
		for(int i=0;i<N;i++){
			for(Line line:lines){
				if(dist[line.from] != INF && dist[line.to] > dist[line.from] + line.time){
					dist[line.to] = dist[line.from] + line.time;
					if(i==N-1) return null;
				}
			}
		}

		return dist;
	}

	private static class Line {
		int from, to, time;
		Line(int from, int to, int time){
			this.from = from;
			this.to = to;
			this.time = time;
		}
	}
}
