import java.io.*;
import java.util.*;

public class BOJ_17390_이건꼭풀어야해 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		int[] arr = new int[N+1];
		st = new StringTokenizer(in.readLine());
		for(int i=1;i<=N;i++) arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);

		for(int i=2;i<=N;i++) arr[i] += arr[i-1];

		StringBuilder sb = new StringBuilder();
		for(int q=0;q<Q;q++){
			st = new StringTokenizer(in.readLine());
			sb.append(-arr[Integer.parseInt(st.nextToken())-1]+arr[Integer.parseInt(st.nextToken())]).append('\n');
		}

		System.out.print(sb);
	}
}
