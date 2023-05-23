import java.io.*;
import java.util.*;

public class BOJ_17143_낚시왕 {
	static int[][] position;
	static int R, C, M;
	static Shark[] sharks;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		position = new int[R][C];

		sharks = new Shark[M + 1];
		for (int i = 1; i <= M; i++) {
			sharks[i] = new Shark(new StringTokenizer(in.readLine()));
			position[sharks[i].r][sharks[i].c] = i;
		}

		int answer = 0;
		int idx;
		for (int i = 0; i < C; i++) {
			idx = catchShark(i);
			if (idx > 0) {
				answer += sharks[idx].z;
				position[sharks[idx].r][sharks[idx].c] = 0;
				sharks[idx] = null;
			}
			moveShark();
		}

		System.out.println(answer);
	}

	private static int catchShark(int c) {
		for (int r = 0; r < R; r++) {
			if (position[r][c] != 0) return position[r][c];
		}
		return 0;
	}

	private static void moveShark() {
		Shark shark;
		for (int i = 1; i <= M; i++) {
			shark = sharks[i];
			if (shark != null) {
				position[shark.r][shark.c] = 0;
				shark.move();
			}
		}

		int nidx;
		int nr, nc;
		for (int i = 1; i <= M; i++) {
			shark = sharks[i];
			if (shark == null) continue;

			nr = shark.r;
			nc = shark.c;
			nidx = position[nr][nc];

			if (nidx == 0) {
				position[nr][nc] = i;
				continue;
			}

			int nz = sharks[nidx].z;
			if (nz > shark.z) {
				sharks[i] = null;
			} else {
				sharks[nidx] = null;
				position[nr][nc] = i;
			}
		}
	}

	private static class Shark {
		int r, c, s, z;
		boolean vertical = false;
		boolean way;

		Shark(StringTokenizer st) {
			this.r = Integer.parseInt(st.nextToken()) - 1;
			this.c = Integer.parseInt(st.nextToken()) - 1;
			this.s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			this.z = Integer.parseInt(st.nextToken());

			if (d < 3) vertical = true;
			this.s = s % ((vertical ? R - 1 : C - 1) * 2);
			this.way = d == 2 || d == 3;
		}

		void move() {
			for (int i = 0; i < s; i++) {
				if ((vertical && r == 0) || (!vertical && c == 0)) way = true;
				else if ((vertical && r == R - 1) || (!vertical && c == C - 1)) way = false;

				if (vertical && way) r++;
				else if (vertical) r--;
				else if (way) c++;
				else c--;
			}
		}

	}
}
