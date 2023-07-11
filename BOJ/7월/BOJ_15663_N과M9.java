import java.io.*;
import java.util.*;

public class BOJ_15663_N과M9 {
	static TreeSet<int[]> set;
	static int[] arr, picked;
	static int N,M;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(in.readLine());
		for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());

		set = new TreeSet<>((o1,o2)->{
			for(int i=0;i<o1.length;i++){
				if(i>=o2.length) return 1;
				else if(o1[i]!=o2[i]) return o1[i]-o2[i];
			}
			return o1.length-o2.length;
		});
		picked = new int[M];
		pick(0,0);

		StringBuilder sb = new StringBuilder();
		for(int[] item:set){
			for(int i=0;i<M;i++){
				sb.append(item[i]).append(' ');
			}
			sb.append('\n');
		}

		System.out.print(sb);
	}
	public static void pick(int cnt, int flag){
		if(cnt==M){
			set.add(picked.clone());
			return;
		}

		for(int i=0;i<N;i++){
			if((flag&1<<i)!=0) continue;
			picked[cnt] = arr[i];
			pick(cnt+1, flag|1<<i);
		}
	}
}
