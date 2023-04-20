import java.io.*;
import java.util.*;

public class BOJ_16948_데스나이트 {
	public static void main(String[] args) throws IOException {
		int[][] delta = {{-2,-1},{-2,1},{0,-2},{0,2},{2,-1},{2,1}};
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		int r1 = Integer.parseInt(st.nextToken());
		int c1 = Integer.parseInt(st.nextToken());
		int r2 = Integer.parseInt(st.nextToken());
		int c2 = Integer.parseInt(st.nextToken());

		boolean[][] board = new boolean[N][N];
		board[r1][c1] = true;
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[]{r1, c1, 0});
		int[] now;
		int nr,nc;
		while (!queue.isEmpty()) {
			now = queue.poll();
			if(now[0]==r2 &&now[1]==c2){
				System.out.println(now[2]);
				return;
			}
			for(int[] d:delta){
				nr = now[0]+d[0];
				nc = now[1]+d[1];
				if(nr<0 || nc<0 || nr>=N || nc>=N || board[nr][nc]) continue;
				queue.offer(new int[]{nr,nc,now[2]+1});
				board[nr][nc] = true;
			}
		}

		System.out.println(-1);
	}
}
