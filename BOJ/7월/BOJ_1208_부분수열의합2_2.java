import java.io.*;
import java.util.*;

public class BOJ_1208_부분수열의합2_2 {
	static int[] arr, count;
	static int N, S, BASE = 2_000_000;
	static long answer;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		arr = new int[N];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

		count = new int[8_000_001];
		find(N / 2, 0, N, true);
		find(0, 0, N / 2, false);

		if (S == 0) answer -= 1;
		System.out.println(answer);
	}

	private static void find(int idx, int sum, int end, boolean type) {
		if (idx == end) {
			if (type) ++count[BASE + sum];
			else answer += count[S - sum + BASE];
			return;
		}
		find(idx + 1, sum + arr[idx], end, type);
		find(idx + 1, sum, end, type);
	}
}
