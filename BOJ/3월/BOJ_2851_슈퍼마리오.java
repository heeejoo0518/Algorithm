import java.io.*;

public class BOJ_2851_슈퍼마리오 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int[] mushroom = new int[11];
		int ans = 0;
		for (int i = 1; i <= 10; i++) {
			mushroom[i] += mushroom[i - 1] + Integer.parseInt(in.readLine());
			if(Math.abs(mushroom[i] - 100)<=Math.abs(ans-100)) ans = mushroom[i];
		}
		System.out.println(ans);

	}
}
