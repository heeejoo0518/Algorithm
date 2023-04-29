import java.io.*;
import java.util.*;

public class BOJ_14497_주난의난 {
	static int N, M;
	static int x1, y1, x2, y2;
	static char[][] input;
	static int[][] count;
	static int[][] delta = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(in.readLine());
		x1 = Integer.parseInt(st.nextToken()) - 1;
		y1 = Integer.parseInt(st.nextToken()) - 1;
		x2 = Integer.parseInt(st.nextToken()) - 1;
		y2 = Integer.parseInt(st.nextToken()) - 1;

		input = new char[N][M];
		count = new int[N][M];
		for (int i = 0; i < N; i++) {
			input[i] = in.readLine().toCharArray();
			Arrays.fill(count[i], -1);
		}

		System.out.println(find());
	}

	public static int find() {
		Deque<int[]> deque = new ArrayDeque<>();
		deque.offer(new int[]{x1, y1});
		count[x1][y1] = 0;

		int[] node;
		int ni, nj;
		while (!deque.isEmpty()) {
			node = deque.poll();

			for (int d = 0; d < 4; d++) {
				ni = node[0] + delta[d][0];
				nj = node[1] + delta[d][1];
				if (!isValid(ni, nj)) continue;

				if(input[ni][nj]=='0') {
					count[ni][nj] = count[node[0]][node[1]];
					deque.offerFirst(new int[]{ni,nj});
				}
				else {
					count[ni][nj] = count[node[0]][node[1]] + 1;
					deque.offerLast(new int[]{ni,nj});
				}
			}
		}

		return count[x2][y2];
	}

	public static boolean isValid(int i, int j) {
		return i >= 0 && i < N && j >= 0 && j < M && count[i][j]==-1;
	}
}
