import java.io.*;
import java.util.*;

public class BOJ_10800_컬러볼 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st;

		Ball[] balls = new Ball[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			balls[i] = new Ball(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(balls, (o1, o2) -> {
			if (o1.size == o2.size) return o1.color - o2.color;
			else return o1.size - o2.size;
		});

		int[] answer = new int[N];//답 저장
		int[] color = new int[N + 1];//색 별 누적합
		int sum = 0;//전체 누적합
		int size = 0, count = 0;//직전 공 크기, 개수

		Ball prev = null;
		for (Ball ball : balls) {
			//직전이랑 사이즈 다르면 -> 전체 누적합에서 본인 색 누적합 빼면 됨.
			//직전이랑 사이즈 같으면 -> 전체 누적합에서 count*size 랑 본인 색 누적합 빼야함.
			//만약 직전과 사이즈, 컬러 동일하다면 -> 직전값 그대로 씀
			answer[ball.idx] = sum - color[ball.color];
			if (size == ball.size) {
				if (prev != null && ball.color == prev.color) {
					answer[ball.idx] = answer[prev.idx];
				} else {
					answer[ball.idx] -= count * size;
				}
				count++;
			} else {
				size = ball.size;
				count = 1;
			}
			sum += ball.size;
			color[ball.color] += ball.size;
			prev = ball;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(answer[i]).append('\n');
		}
		System.out.print(sb);
	}

	public static class Ball {
		int color, size, idx;

		Ball(int idx, int color, int size) {
			this.idx = idx;
			this.color = color;
			this.size = size;
		}
	}
}
