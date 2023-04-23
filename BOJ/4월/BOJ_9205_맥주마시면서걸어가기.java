import java.io.*;
import java.util.*;

public class BOJ_9205_맥주마시면서걸어가기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N, places[][];
		Queue<Integer> queue;
		boolean[] visited;

		for(int tc=0;tc<T;tc++){
			N = Integer.parseInt(in.readLine());
			places = new int[N+2][2];
			visited = new boolean[N+2];

			for(int n=0;n<N+2;n++){
				st = new StringTokenizer(in.readLine());
				places[n] = new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
			}

			queue = new ArrayDeque<>();
			queue.offer(0);
			int[] now;
			while(!queue.isEmpty()){
				if(queue.peek()==N+1){
					break;
				}

				now = places[queue.poll()];

				for(int i=1;i<=N+1;i++){
					if(visited[i]) continue;
					if(calcDistance(now,places[i])<=1000){
						queue.offer(i);
						visited[i] = true;
					}
				}
			}

			if(visited[N+1]) sb.append("happy\n");
			else sb.append("sad\n");

		}

		System.out.print(sb);
	}

	public static int calcDistance(int[] a, int[] b){
		return Math.abs(a[0]-b[0])+Math.abs(a[1]-b[1]);
	}
}
