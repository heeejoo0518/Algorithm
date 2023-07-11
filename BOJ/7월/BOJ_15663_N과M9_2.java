import java.io.*;
import java.util.*;

public class BOJ_15663_N과M9_2 {
	static int[] arr, picked;
	static int N,M;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];
		st = new StringTokenizer(in.readLine());
		for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);

		picked = new int[M];
		pick(0,0);

		System.out.print(sb);
	}
	public static void pick(int cnt, int flag){
		if(cnt==M){
			for(int i=0;i<M;i++){
				sb.append(picked[i]).append(' ');
			}
			sb.append('\n');
			return;
		}

		int before = 0;
		for(int i=0;i<N;i++){
			if((flag&1<<i)!=0 || before == arr[i]) continue;
			picked[cnt] = arr[i];
			before = arr[i];
			pick(cnt+1, flag|1<<i);
		}
	}
}
