import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

//수빈이 시간 기준
public class BOJ_17071_숨바꼭질5_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int END = 500000;

		boolean[][] visited = new boolean[END + 1][2];
		visited[N][0] = true;

		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(N);

		int now, time = 0, mod = 0, size, move = K;

		//time(=depth)으로 체크
		//해당 depth+1에 가능한 곳 전부 방문처리
		//다음번 반복문 초반에 동생위치가 END이상인지(순서중요), 이전에 방문한 적 있는지 체크
		//반복문 초반에 체크하는 이유는 time=0인 경우를 쉽게 체크하려고.
		while (!queue.isEmpty()) {
			if(move > END){//꼭 이 위치여야 함.
				System.out.println(-1);
				return;
			}
			if(visited[move][mod]){
				System.out.println(time);
				return;
			}

			//다음 depth 방문처리 및 준비(move, time)
			size = queue.size();
			time++;
			mod = time%2;
			move += time;

			for(int s=0;s<size;s++){
				now = queue.poll();

				if (now * 2 <= END && !visited[now * 2][mod]) {
					queue.offer(now * 2);
					visited[now * 2][mod] = true;
				}
				if (now + 1 <= END && !visited[now + 1][mod]) {
					queue.offer(now + 1);
					visited[now + 1][mod] = true;
				}
				if (now - 1 >= 0 && !visited[now - 1][mod]) {
					queue.offer(now - 1);
					visited[now - 1][mod] = true;
				}
			}

		}

	}
}
