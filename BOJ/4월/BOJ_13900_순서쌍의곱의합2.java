import java.io.*;
import java.util.*;

public class BOJ_13900_순서쌍의곱의합2 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		long[] num = new long[N];
		StringTokenizer st = new StringTokenizer(in.readLine());

		long sum = 0;
		long n;
		num[0] = Integer.parseInt(st.nextToken());
		for(int i=1;i<N;i++){
			n = Integer.parseInt(st.nextToken());
			num[i] = n + num[i-1];
			sum += num[i-1]*n;
		}

		System.out.println(sum);
	}
}
