import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D3_1289_원재의메모리복구하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());

		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			char[] memory = in.readLine().toCharArray();
			int count = 0;
			char now = '0';

			for (int i = 0; i < memory.length; i++) {
				if (memory[i] != now) {
					count++;
					now = now == '0' ? '1' : '0';
					// now = memory[i];
				}
			}

			sb.append("#").append(tc).append(" ").append(count).append("\n");
		}

		in.close();

		System.out.print(sb);
	}

}
