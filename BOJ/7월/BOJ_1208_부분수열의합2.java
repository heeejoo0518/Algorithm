import java.io.*;
import java.util.*;

public class BOJ_1208_부분수열의합2 {
	static int[] arr;
	static int N, S;
	static long answer;
	static Map<Integer, Integer> map;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(in.readLine());
		for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());

		map = new HashMap<>();
		int half = N%2==0? N/2-1:N/2;
		find(half,0);
		find(0,0,half);

		if(S==0) answer-=1;
		System.out.println(answer);
	}

	private static void find(int idx, int sum){
		if(idx==N) {
			map.put(sum, map.getOrDefault(sum,0)+1);
			return;
		}
		find(idx+1,sum+arr[idx]);
		find(idx+1, sum);
	}

	private static void find(int idx, int sum, int end){
		if(idx==end){
			answer += map.getOrDefault(S-sum,0);
			return;
		}
		find(idx+1, sum+arr[idx],end);
		find(idx+1, sum,end);
	}
}
