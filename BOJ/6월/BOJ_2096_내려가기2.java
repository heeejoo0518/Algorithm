import java.io.*;
import java.util.*;

public class BOJ_2096_내려가기2 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[][] min = new int[2][3];
		int[][] max = new int[2][3];

		StringTokenizer st;
		for(int i=1;i<=N;i++){
			st = new StringTokenizer(in.readLine());
			for(int j=0;j<3;j++){
				min[1][j] = max[1][j] = Integer.parseInt(st.nextToken());
			}

			min[1][0] += Math.min(min[0][0], min[0][1]);
			max[1][0] += Math.max(max[0][0], max[0][1]);

			min[1][1] += Math.min(Math.min(min[0][0], min[0][1]), min[0][2]);
			max[1][1] += Math.max(Math.max(max[0][0], max[0][1]), max[0][2]);

			min[1][2] += Math.min(min[0][1], min[0][2]);
			max[1][2] += Math.max(max[0][1], max[0][2]);

			for(int j=0;j<3;j++){
				min[0][j] = min[1][j];
				max[0][j] = max[1][j];
			}
		}

		int ans1 = Math.max(max[0][0], Math.max(max[0][1], max[0][2]));
		int ans2 = Math.min(min[0][0], Math.min(min[0][1], min[0][2]));

		System.out.println(ans1 +" "+ ans2);
	}
}
