import java.io.*;

public class BOJ_2775_부녀회장이될테야 {
	public static void main(String[] args) throws Exception {
		//0층 i호 = i명
		int[][] apartment = new int[15][15];
		for (int i = 1; i < 15; i++) apartment[0][i] = i;

		//1층 i호 = 0층 1호 ~ i호까지의 합
		for (int k = 1; k < 15; k++) {
			for (int n = 1; n < 15; n++) {
				apartment[k][n] = apartment[k][n-1] + apartment[k-1][n];
			}
		}

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t=0;t<T;t++){
			int K = Integer.parseInt(in.readLine());
			int N = Integer.parseInt(in.readLine());

			sb.append(apartment[K][N]).append('\n');
		}
		System.out.print(sb);
	}
}
