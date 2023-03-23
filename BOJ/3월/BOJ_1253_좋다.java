import java.io.*;
import java.util.*;

public class BOJ_1253_좋다 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);

		int find, answer = 0;
		for (int i = 0; i < N; i++) {
			find = arr[i];
			int left = 0, right = N - 1, sum;
			while (left < right) {
				sum = arr[left] + arr[right];
				if (sum > find) right--;
				else if (sum < find) left++;
				else if (left == i) left++;
				else if (right == i) right--;
				else {
					answer++;
					break;
				}
			}
		}

		System.out.println(answer);
	}
}

