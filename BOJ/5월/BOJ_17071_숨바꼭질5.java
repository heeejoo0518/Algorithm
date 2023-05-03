import java.io.*;
import java.util.*;

//동생 시간 기준
public class BOJ_17071_숨바꼭질5 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int END = 500000;

		int[][] visited = new int[2][END + 1];
		Arrays.fill(visited[0], -1);
		Arrays.fill(visited[1], -1);

		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[]{N, 0});
		visited[0][N] = 0;

		int now, time;

		//가능한 경우를 전부 구한 후 동생 위치에 맞춰 반환.
		while (!queue.isEmpty()) {
			now = queue.peek()[0];
			time = queue.poll()[1] + 1;

			if (now * 2 <= END && visited[time%2][now * 2] == -1) {
				queue.offer(new int[]{now * 2, time});
				visited[time%2][now * 2] = time;
			}
			if (now + 1 <= END && visited[time%2][now + 1] == -1) {
				queue.offer(new int[]{now + 1, time});
				visited[time%2][now + 1] = time;
			}
			if (now - 1 >= 0 && visited[time%2][now - 1] == -1) {
				queue.offer(new int[]{now - 1, time});
				visited[time%2][now - 1] = time;
			}
		}

		//동생 i(시간)에 맞춰서 visited가 변경될테니 다른 곳(visited)에 더 작은 값이 있어도 상관x
		int answer = -1;
		for(int k=K,i=0;k<=END;i++,k+=i){
			if(visited[i%2][k] != -1 && visited[i%2][k] <= i){
				answer = i;
				break;
			}
		}

		System.out.println(answer);
	}
}
