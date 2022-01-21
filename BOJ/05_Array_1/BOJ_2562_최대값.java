import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2562_최대값 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int[] result = new int[2];
		for (int i = 1; i < 10; i++) {
			int num = Integer.parseInt(in.readLine());
			if (result[0] < num) {
				result[0] = num;
				result[1] = i;
			}
		}
		System.out.printf("%d\n%d", result[0], result[1]);
	}

}
