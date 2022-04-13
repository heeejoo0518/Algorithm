import java.io.*;
import java.util.*;

public class SW_4013_특이한자석 {
	static int[][] magnet = new int[4][8];
	static int[] idx = new int[4];
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		for(int tc=1;tc<=T;tc++){
			int K = Integer.parseInt(in.readLine());
			for(int i=0;i<4;i++){
				st = new StringTokenizer(in.readLine());
				for(int j=0;j<8;j++){
					magnet[i][j] = Integer.parseInt(st.nextToken());
				}
				idx[i] = 0;
			}

			for(int k=0;k<K;k++){
				st = new StringTokenizer(in.readLine());
				visited = new boolean[4];
				turn(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken()));
			}

			int score = 0;

			for(int i=0;i<4;i++){
				if(magnet[i][idx[i]]==1) score += 1<<i;
			}


			sb.append('#').append(tc).append(' ').append(score).append('\n');
		}

		System.out.print(sb);
	}

	private static void turn(int num, int way) {
		if(visited[num]) return;
		visited[num] = true;

		int top = idx[num];
		int left = (top+6)%8;
		int right = (top+2)%8;

		if(num>0){
			if(magnet[num-1][(idx[num-1]+2)%8]!=magnet[num][left]) turn(num-1,-way);
		}

		if(num<3){
			if(magnet[num+1][(idx[num+1]+6)%8]!=magnet[num][right]) turn(num+1, -way);
		}

		idx[num] = (top+8-way)%8;
	}
}
