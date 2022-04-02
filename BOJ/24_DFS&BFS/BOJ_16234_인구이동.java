import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16234_인구이동 {
	static int N,L,R;
	static int[][] area,next;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		area = new int[N][N];
		for(int i=0;i<N;i++){
			st = new StringTokenizer(in.readLine());
			for(int j=0;j<N;j++){
				area[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		boolean result = true;
		int cnt = 0;
		while(result){
			result = false;
			visited = new boolean[N][N];
			next = new int[N][N];
			for(int i=0;i<N;i++){
				for(int j=0;j<N;j++){
					if(visited[i][j]) continue;
					visited[i][j] = true;

					result = result|bfs(new int[]{i,j});
				}
			}
			area = next;
			if(result) cnt++;
		}

		System.out.println(cnt);
	}

	private static boolean bfs(int[] pos) {
		int[][] deltas =  {{1,0},{-1,0},{0,1},{0,-1}};
		int total = 0;

		ArrayList<int[]> list = new ArrayList<>();
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(pos);

		while(!queue.isEmpty()){
			pos = queue.poll();
			list.add(pos);

			int pop = area[pos[0]][pos[1]];
			total += pop;

			for(int d=0;d<4;d++){
				int ni = pos[0] + deltas[d][0];
				int nj = pos[1] + deltas[d][1];
				if(ni<0 || nj< 0 || ni>=N || nj>=N || visited[ni][nj]) continue;
				int diff = Math.abs(pop-area[ni][nj]);
				if(diff<L || diff>R) continue;
				visited[ni][nj] = true;
				queue.offer(new int[]{ni,nj});
			}
		}

		int div = total/list.size();
		for (int[] npos : list) {
			next[npos[0]][npos[1]] = div;
		}

		return list.size()!=1;
	}
}
