import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class BOJ_2473_세용액 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		long[] arr = new long[N];
		for (int i = 0; i < N; i++) arr[i] = Long.parseLong(st.nextToken());
		Arrays.sort(arr);

		long A = 0, B = 0, C = 0;
		int l, r;
		long sum;
		long tmp = 3000000001L;
		for (int standard = 0; standard < N - 2; standard++) {
			l = standard+1;
			r = N-1;
			while(l<r){
				sum = arr[standard]+arr[l]+arr[r];
				if(abs(sum)<tmp){
					A = arr[standard];
					B = arr[l];
					C = arr[r];
					tmp = abs(sum);
				}
				if(sum < 0) l++;
				else r--;
			}
		}
		System.out.println(A + " " + B + " " + C);

	}
}
