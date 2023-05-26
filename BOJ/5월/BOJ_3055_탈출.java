import java.io.*;
import java.util.*;

public class BOJ_3055_탈출 {
	static int R,C;
	static char[][] map;
	static int[][] dist;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		dist = new int[R][C];

		Queue<int[]> water = new ArrayDeque<>();
		Queue<int[]> hedgehog = new ArrayDeque<>();

		for (int r = 0, c = 0; r < R; r++, c = 0) {
			for (char ch : in.readLine().toCharArray()) {
				if (ch == 'S') {
					hedgehog.offer(new int[]{r, c, 1});
				} else if (ch == '*') {
					water.offer(new int[]{r, c, 1});
					dist[r][c] = 1;
				}
				map[r][c++] = ch;
			}
		}

		int[][] deltas = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		int[] now;
		int nr, nc,nt;
		while (!water.isEmpty()) {
			now = water.poll();
			for (int[] d : deltas) {
				nr = now[0] + d[0];
				nc = now[1] + d[1];
				nt = now[2] + 1;
				if(isValid(true,nr,nc,nt)) {
					dist[nr][nc] = nt;
					water.offer(new int[]{nr, nc, nt});
				}
			}
		}

		while(!hedgehog.isEmpty()){
			now = hedgehog.poll();
			if(map[now[0]][now[1]]=='D'){
				System.out.println(now[2]-1);
				return;
			}
			for (int[] d : deltas) {
				nr = now[0] + d[0];
				nc = now[1] + d[1];
				nt = now[2] + 1;
				if(isValid(false,nr,nc,nt)){
					hedgehog.offer(new int[]{nr, nc, nt});
					dist[nr][nc] = 1;
				}
			}
		}

		System.out.println("KAKTUS");
	}

	private static boolean isValid(boolean water, int nr, int nc, int time){
		if (nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc] == 'X') return false;
		if(water) return dist[nr][nc] == 0 && map[nr][nc] != 'D';
		return dist[nr][nc]==0 || dist[nr][nc] > time;
	}
}
