import java.io.*;
import java.util.*;

public class BOJ_2467_용액 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] input = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) input[i] = Integer.parseInt(st.nextToken());

		int left = 0, right = N - 1;
		int tmp = 2000000000;
		int now;
		int A=0,B=0;
		while (left < right) {
			now = input[left] + input[right];
			if (Math.abs(now) < tmp) {
				tmp = Math.abs(now);
				A = input[left];
				B = input[right];
			}
			if (now < 0) left++;
			else right--;

		}
		System.out.println(A + " " + B);
	}
}
