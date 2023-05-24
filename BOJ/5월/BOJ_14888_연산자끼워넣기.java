import java.io.*;
import java.util.*;

public class BOJ_14888_연산자끼워넣기 {
	static int MIN = 1000000001;
	static int MAX = -1000000001;
	static int[] picked, num, operator;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		num = new int[N];
		for (int i = 0; i < N; i++) num[i] = Integer.parseInt(st.nextToken());
		operator = new int[4];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < 4; i++) operator[i] = Integer.parseInt(st.nextToken());

		picked = new int[N - 1];
		pick(0);

		System.out.println(MAX + "\n" + MIN);
	}

	public static void pick(int cnt) {
		if (cnt == N - 1) {
			int result = calc();
			if(MAX<result) MAX = result;
			if(MIN>result) MIN = result;
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (operator[i] == 0) continue;
			picked[cnt] = i;
			operator[i]--;
			pick(cnt+1);
			operator[i]++;
		}
	}

	public static int calc() {
		int result = num[0];
		for (int i = 1; i < N; i++) {
			if (picked[i - 1] == 0) result += num[i];
			else if (picked[i - 1] == 1) result -= num[i];
			else if (picked[i - 1] == 2) result *= num[i];
			else result /= num[i];
		}
		return result;
	}
}
