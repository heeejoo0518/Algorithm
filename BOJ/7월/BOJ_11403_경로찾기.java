import java.io.*;
import java.util.*;

public class BOJ_11403_경로찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[][] matrix = new int[N][N];

		//입력
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		//탐색-플로이드워셜
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(matrix[i][j]==1) continue;
					matrix[i][j] = matrix[i][k] & matrix[k][j];
				}
			}
		}

		//출력
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(matrix[i][j]).append(' ');
			}
			sb.append('\n');
		}

		System.out.print(sb);
	}
}
