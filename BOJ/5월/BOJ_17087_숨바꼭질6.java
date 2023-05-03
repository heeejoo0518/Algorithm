import java.io.*;
import java.util.*;

public class BOJ_17087_숨바꼭질6 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] A = new int[N+1];
		A[0] = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(in.readLine());
		for(int i=1;i<=N;i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(A);
		int answer = Math.abs(A[0]-A[1]);
		for(int i=2;i<=N;i++) answer = gcd(answer, Math.abs(A[i]-A[i-1]));

		System.out.println(answer);
	}
	public static int gcd(int a, int b){
		if(a<b){
			int tmp = a;
			a = b;
			b = tmp;
		}
		if(b==0) return a;
		return gcd(b,a%b);
	}
}
