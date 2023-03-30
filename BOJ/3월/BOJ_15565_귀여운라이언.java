import java.io.*;
import java.util.*;

public class BOJ_15565_귀여운라이언 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		boolean[] toy = new boolean[N];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) toy[i] = st.nextToken().equals("1");

		int min = N + 1, ryan = toy[0] ? 1 : 0;
		int l = 0, r = 1;
		while (l < r) {
			if (ryan >= K || r >= N) {
				if (ryan >= K) min = Math.min(min, r - l);
				if (toy[l++]) --ryan;
			} else if (toy[r++]) {
				++ryan;
			}
		}

		if (min == N + 1) System.out.println(-1);
		else System.out.println(min);
	}
}
