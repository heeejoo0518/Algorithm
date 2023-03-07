import java.io.*;
import java.util.*;

public class BOJ_20300_서강근육맨 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		long[] health = new long[N];
		for (int i = 0; i < N; i++) health[i] = Long.parseLong(st.nextToken());
		Arrays.sort(health);
		long M = health[N-1];
		int end = N-1;
		if (N % 2 != 0) end -= 1;
		for(int i=0;i<N>>1;i++){
			M = Math.max(M,health[i]+health[end-i]);
		}
		System.out.println(M);
	}

}
