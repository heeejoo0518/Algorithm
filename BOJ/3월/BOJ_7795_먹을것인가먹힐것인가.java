import java.io.*;
import java.util.*;

public class BOJ_7795_먹을것인가먹힐것인가 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();

		int[] A, B;
		int N,M, answer;
		StringTokenizer st;
		for(int tc=0;tc<T;tc++){
			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			A = new int[N];
			B = new int[M];

			st = new StringTokenizer(in.readLine());
			for(int i=0;i<N;i++) A[i] = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(in.readLine());
			for(int i=0;i<M;i++) B[i] = Integer.parseInt(st.nextToken());
			Arrays.sort(B);

			answer = 0;
			int l,h,m;
			for(int a:A){
				l = 0;
				h = M-1;
				while(l<=h){
					m = (l+h)/2;
					if(B[m]<a) l = m+1;
					else h = m-1;
				}
				answer += l;
			}


			sb.append(answer).append('\n');
		}

		System.out.print(sb);
	}
}
