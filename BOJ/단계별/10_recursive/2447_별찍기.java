import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2447_별찍기10 {
	static char[][] board;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());
		
		in.close();
		
		board = new char[N][N];

		printStar(0, 0, N);

		printBoard();

	}

	private static void printStar(int i, int j, int n) {
		if (n == 1) {
			board[i][j] = '*';
			return;
		}

		int nextN = n / 3;

		for (int k = 0; k < 3; k++) {
			for (int l = 0; l < 3; l++) {
				if (k == 1 && l == 1) continue;		//비어야 하는 부분 continue;
				printStar(i + nextN * k, j + nextN * l, nextN);
			}
		}
	}

	private static void printBoard() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] == '*')
					sb.append(board[i][j]);
				else
					sb.append(' '); // 공백은 따로 체크
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}


// printStar 변수 넘길 때 간단하게 하려고 짜봤다가 머리만 터짐^^...
//for (int ni = i; ni < i + n; ni += nextN) {
//	for (int nj = j; nj < j + n; nj += nextN) {
//		if (ni == i + nextN && nj == j + nextN)
//			continue;
//		printStar(ni, nj, nextN);
//	}
//}
