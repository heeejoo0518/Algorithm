import java.io.*;
import java.util.*;

public class BOJ_3273_두수의합 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		int[] arr = new int[N];
		for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(in.readLine());
		Arrays.sort(arr);

		int l = 0, r = N-1, sum, answer = 0;
		while(l<r && r < N){
			sum = arr[l]+arr[r];
			if(sum < X) l++;
			else if(sum > X) r--;
			else{
				answer++;
				l++;
			}
		}
		System.out.println(answer);
	}
}
