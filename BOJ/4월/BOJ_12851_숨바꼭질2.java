import java.io.*;
import java.util.*;

public class BOJ_12851_숨바꼭질2 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] way = new int[100001][2];//시간, 경우의 수
		Queue<Integer> queue = new ArrayDeque<>();
		way[N][0] = way[N][1] = 1;
		queue.offer(N);

		int END = 100000;
		int now;
		while (!queue.isEmpty()) {
			now = queue.poll();
			if(now==K) break;

			if (now * 2 <= END && (way[now * 2][0] == 0 || way[now * 2][0] == way[now][0] + 1)) {
				if (way[now * 2][0] == 0) {
					way[now * 2][0] = way[now][0] + 1;
				}
				way[now * 2][1]++;
				queue.offer(now*2);
			}
			if (now - 1 >= 0 && (way[now - 1][0] == 0 || way[now - 1][0] == way[now][0] + 1)) {
				if (way[now - 1][0] == 0) {
					way[now - 1][0] = way[now][0] + 1;
				}
				way[now - 1][1]++;
				queue.offer(now-1);
			}
			if (now + 1 <= END && (way[now + 1][0] == 0 || way[now + 1][0] == way[now][0] + 1)) {
				if (way[now + 1][0] == 0) {
					way[now + 1][0] = way[now][0] + 1;
				}
				way[now + 1][1]++;
				queue.offer(now+1);
			}
		}

		System.out.println(way[K][0]-1 + "\n" + way[K][1]);
	}
}
