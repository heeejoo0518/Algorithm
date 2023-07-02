import java.io.*;
import java.util.*;

public class BOJ_1516_게임개발 {
	static int[] time;
	static Building[] buildings;

	private static class Building {
		int time, num;
		ArrayList<Integer> next;

		Building(int num, int time) {
			this.num = num;
			this.time = time;
			this.next = new ArrayList<>();
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		buildings = new Building[N];
		StringTokenizer st;
		int num;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			buildings[i] = new Building(i, Integer.parseInt(st.nextToken()));
			while ((num = Integer.parseInt(st.nextToken())) != -1) {
				buildings[i].next.add(num - 1);
			}
		}

		time = new int[N];
		Arrays.fill(time, -1);
		for (int i = 0; i < N; i++) dfs(i);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) sb.append(time[i]).append('\n');
		System.out.print(sb);
	}

	private static void dfs(int idx) {
		Building building = buildings[idx];
		if (time[building.num] != -1) return;

		int max = 0;
		for (int n : building.next) {
			if (time[n] == -1) {
				dfs(n);
			}
			max = Math.max(max, time[n]);
		}

		time[building.num] = max + building.time;
	}
}
