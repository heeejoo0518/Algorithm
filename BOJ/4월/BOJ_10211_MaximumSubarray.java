import java.io.*;
import java.util.*;

public class BOJ_10211_MaximumSubarray {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		int N, max;
		int[] array;
		StringTokenizer st;
		for(int tc=0;tc<T;tc++){
			N = Integer.parseInt(in.readLine());
			st = new StringTokenizer(in.readLine());
			array = new int[N];
			max = array[0] = Integer.parseInt(st.nextToken());
			for(int i=1;i<N;i++){
				array[i] = Integer.parseInt(st.nextToken());
				if(array[i-1]+array[i] > array[i]) array[i] += array[i-1];
				max = Math.max(max,array[i]);
			}
			sb.append(max).append('\n');
		}
		System.out.print(sb);
	}
}
