import java.io.*;
import java.util.*;

public class BOJ_2636_치즈 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		boolean[][] board = new boolean[N][M];
		boolean[][] visited = new boolean[N][M];
		int total = 0;

		for(int i=0;i<N;i++){
			st = new StringTokenizer(in.readLine());
			for(int j=0;j<M;j++){
				board[i][j] = st.nextToken().charAt(0)=='1';
				if(board[i][j]) total++;
			}
		}

		int[] answer = new int[]{0,total};//0:시간 1:개수(1시간전)
		int[][] deltas = {{1,0},{-1,0},{0,1},{0,-1}};

		Deque<int[]> deque = new ArrayDeque<>();
		deque.offer(new int[]{0,0,0});
		visited[0][0] = true;

		int n, m, h, nn, nm;
		while(!deque.isEmpty()){
			n = deque.peek()[0];
			m = deque.peek()[1];
			h = deque.poll()[2];

			if(h>answer[0]) {
				answer[0] = h;
				answer[1] = total;
			}

			if(board[n][m]) total--;

			for(int[] d:deltas){
				nn = n+d[0];
				nm = m+d[1];
				if(nn<0 || nn>N || nm < 0 || nm > M || visited[nn][nm]) continue;
				if(board[nn][nm]) deque.offerLast(new int[]{nn,nm,h+1});
				else deque.offerFirst(new int[]{nn,nm,h});
				visited[nn][nm] = true;
			}
		}

		System.out.println(answer[0]+"\n"+answer[1]);
	}
}