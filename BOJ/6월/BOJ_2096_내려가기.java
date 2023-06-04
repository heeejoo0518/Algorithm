import java.io.*;
import java.util.*;

public class BOJ_2096_내려가기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[][] min = new int[N+1][3];
		int[][] max = new int[N+1][3];

		int num;
		StringTokenizer st;
		for(int i=1;i<=N;i++){
			st = new StringTokenizer(in.readLine());
			num = Integer.parseInt(st.nextToken());
			min[i][0] = Math.min(min[i-1][0], min[i-1][1]) + num;
			max[i][0] = Math.max(max[i-1][0], max[i-1][1]) + num;

			num = Integer.parseInt(st.nextToken());
			min[i][1] = Math.min(min[i-1][0],Math.min(min[i-1][1], min[i-1][2])) + num;
			max[i][1] = Math.max(max[i-1][0],Math.max(max[i-1][1], max[i-1][2])) + num;

			num = Integer.parseInt(st.nextToken());
			min[i][2] = Math.min(min[i-1][1], min[i-1][2]) + num;
			max[i][2] = Math.max(max[i-1][1], max[i-1][2]) + num;
		}

		int ans1 = Math.max(max[N][0], Math.max(max[N][1], max[N][2]));
		int ans2 = Math.min(min[N][0], Math.min(min[N][1], min[N][2]));

		System.out.println(ans1 +" "+ ans2);
	}
}
