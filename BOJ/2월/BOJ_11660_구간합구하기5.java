import java.io.*;
import java.util.*;

public class BOJ_11660_구간합구하기5 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] board = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 1; j <= N; j++) {
				//가로, 세로는 더하고 대각선은 빼기(중복)
				board[i][j] = board[i - 1][j] + board[i][j - 1] - board[i-1][j-1] + Integer.parseInt(st.nextToken());
			}
		}


		StringBuilder sb = new StringBuilder();
		int x1, y1, x2, y2, sum;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());

			//가로 세로 빼고 대각선은 더하기(중복)
			sum = board[x2][y2] + board[x1-1][y1-1] - board[x2][y1-1] - board[x1-1][y2];

			sb.append(sum).append("\n");
		}

		System.out.print(sb);
	}
}
