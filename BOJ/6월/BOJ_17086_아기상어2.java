import java.io.*;
import java.util.*;

public class BOJ_17086_아기상어2 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Queue<int[]> queue = new ArrayDeque<>();
		int[][] board = new int[N][M];
		for(int i=0;i<N;i++){
			st = new StringTokenizer(in.readLine());
			for(int j=0;j<M;j++){
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j]==1) queue.offer(new int[]{i,j});
			}
		}

		int max = 0;
		int[][] deltas = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
		int[] now;
		int ni,nj,val;
		while(!queue.isEmpty()){
			now = queue.poll();
			val = board[now[0]][now[1]];
			max = Math.max(max,val);

			for(int[] d:deltas){
				ni = now[0]+d[0];
				nj = now[1]+d[1];
				if(ni<0||nj<0||ni>=N||nj>=M ||board[ni][nj]!=0) continue;
				board[ni][nj] = val+1;
				queue.offer(new int[]{ni,nj});
			}
		}

		System.out.println(max-1);
	}
}
