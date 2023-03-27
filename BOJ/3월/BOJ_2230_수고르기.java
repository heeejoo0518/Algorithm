import java.io.*;
import java.util.*;

public class BOJ_2230_수고르기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		for(int i=0;i<N;i++) arr[i] = Integer.parseInt(in.readLine());
		Arrays.sort(arr);

		int min = 2000000000;
		int l = 0,r = 0,diff;
		while(l<=r){
			diff = arr[r]-arr[l];
			if(diff<M) {
				if(++r == N) break;
			}
			else {
				l++;
				min = Math.min(min,diff);
				if(min==M) break;
			}
		}

		System.out.println(min);
	}
}
