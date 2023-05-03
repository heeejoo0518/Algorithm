import java.io.*;
import java.util.*;

public class BOJ_13913_숨바꼭질4 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int END = 100000;

		//직전 위치 저장
		int[] save = new int[END + 1];
		Arrays.fill(save, -1);
		save[N] = -2;

		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(N);

		int now;
		while (!queue.isEmpty()) {
			now = queue.poll();
			if(now==K) break;

			if (now * 2 <= END && save[now * 2] == -1) {
				save[now * 2] = now;
				queue.offer(now * 2);
				if(now*2==K) break;
			}
			if (now + 1 <= END && save[now + 1] == -1) {
				save[now + 1] = now;
				queue.offer(now + 1);
				if(now+1==K) break;
			}
			if (now - 1 >= 0 && save[now - 1] == -1) {
				save[now - 1] = now;
				queue.offer(now - 1);
				if(now-1==K) break;
			}
		}

		int find = K;
		ArrayList<Integer> list = new ArrayList<>();
		while (save[find] != -2) {
			list.add(find);
			find = save[find];
		}

		StringBuilder sb = new StringBuilder();
		sb.append(list.size()).append('\n');
		sb.append(N).append(' ');
		for (int i = list.size() - 1; i >= 0; i--) {
			sb.append(list.get(i)).append(' ');
		}

		System.out.println(sb);
	}
}
