import java.io.*;
import java.util.*;

public class BOJ_1644_소수의연속합 {
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());

		// 4000000까지의 소수 구하기 + 리스트에 모으기
		boolean[] prime = new boolean[N + 1];
		prime[0] = prime[1] = true;
		ArrayList<Integer> primeList = new ArrayList<>();
		for (int i = 2; i <= N; i++) {
			if (prime[i]) continue;
			primeList.add(i);
			for (int j = i+i; j <= N; j += i) {
				prime[j] = true;
			}
		}

		//소수만 있는 합 구하기
		int answer = 0;
		int sum;
		for (int left = 0; left < primeList.size(); left++) {
			sum = 0;
			for (int right = left; right < primeList.size(); right++) {
				sum += primeList.get(right);
				if (sum == N) answer++;
				if (sum >= N) break;
			}
		}

		//출력
		System.out.println(answer);
	}

}
