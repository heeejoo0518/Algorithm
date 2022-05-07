import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_8958_퀴즈 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder builder = new StringBuilder();

		for (int tc = 0; tc <T; tc++) {
			int score = 0;
			int cnt = 0;
			char[] chars = in.readLine().toCharArray();
			for (char ch : chars) {
				if (ch == 'O') {
					cnt++;
					score += cnt;
				} else {
					cnt = 0;
				}
			}

			builder.append(score).append("\n");
		}
		
		System.out.println(builder.toString());
	}
}
