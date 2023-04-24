import java.io.*;
import java.util.*;

public class BOJ_2015_수들의합4 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Map<Integer, Integer> map = new HashMap<>();
		int[] sum = new int[N + 1];
		st = new StringTokenizer(in.readLine());
		for (int i = 1; i <= N; i++) {
			sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
		}

		//sum[i] - K = sum[j-1], N>=i>=j>=1 이다. 따라서 sum[1-1] = sum[0]값을 미리 저장해두어야 함.
		map.put(0,1);

		long answer = 0;
		for (int j = 1; j <= N; j++) {
			answer += map.getOrDefault(sum[j] - K, 0);
			map.put(sum[j], map.getOrDefault(sum[j], 0) + 1);
		}

		System.out.println(answer);
	}
}
