import java.io.*;
import java.util.*;

public class BOJ_10986_나머지합 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N =Integer.parseInt(st.nextToken());
		int M =Integer.parseInt(st.nextToken());
		int[] arr = new int[N+1];
		long[] remainder = new long[M];
		st = new StringTokenizer(in.readLine());
		for(int i=1;i<=N;i++) {
			arr[i] = (arr[i-1]+Integer.parseInt(st.nextToken())%M)%M;
			remainder[arr[i]]++;
		}

		//조합
		long answer = remainder[0];
		for(int i=0;i<M;i++){
			if(remainder[i]<2) continue;
			answer += (remainder[i]*(remainder[i]-1)/2);
		}

		System.out.println(answer);
	}
}
