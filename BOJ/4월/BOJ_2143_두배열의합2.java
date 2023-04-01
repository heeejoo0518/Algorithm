import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2143_두배열의합2 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		int N = Integer.parseInt(in.readLine());
		int[] A = new int[N];
		Map<Integer, Integer> Amap = new HashMap<>();
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=0;i<N;i++) A[i] = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(in.readLine());
		int[] B = new int[M];
		st = new StringTokenizer(in.readLine());
		for(int i=0;i<M;i++) B[i] = Integer.parseInt(st.nextToken());

		int sum;
		for(int i=0;i<N;i++) {
			sum = A[i];
			Amap.put(sum,Amap.getOrDefault(sum,0)+1);
			for(int j=i+1;j<N;j++){
				sum += A[j];
				Amap.put(sum,Amap.getOrDefault(sum,0)+1);
			}
		}

		long answer = 0;
		for(int i=0;i<M;i++){
			sum = B[i];
			answer += Amap.getOrDefault(T-sum,0);
			for(int j=i+1;j<M;j++){
				sum += B[j];
				answer += Amap.getOrDefault(T-sum,0);
			}
		}

		System.out.println(answer);
	}


}
