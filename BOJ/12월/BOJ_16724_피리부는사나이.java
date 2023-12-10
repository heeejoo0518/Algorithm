import java.io.*;
import java.util.*;

public class BOJ_16724_피리부는사나이 {
	static int N, M, answer;
	static char[][] map;
	static int[][] count;
	static int[][] deltas = {{-1,0},{1,0},{0,-1},{0,1}};//UDLR
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][];
		for(int i=0;i<N;i++){
			map[i] = in.readLine().toCharArray();
		}

		count = new int[N][M];
		int num=1;
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				if(count[i][j] == 0 && ++num == dfs(num,i,j)) answer++;
			}
		}

		System.out.println(answer);
	}
	public static int dfs(int num, int i, int j){
		if(count[i][j] != 0) return count[i][j];
		count[i][j] = num;

		int next = num;
		int ni,nj;
		switch(map[i][j]){
			case 'U':
				ni = i+deltas[0][0];
				nj = j+deltas[0][1];
				break;
			case 'D':
				ni = i+deltas[1][0];
				nj = j+deltas[1][1];
				break;
			case 'L':
				ni = i+deltas[2][0];
				nj = j+deltas[2][1];
				break;
			default:
				ni = i+deltas[3][0];
				nj = j+deltas[3][1];
				break;
		}

		if(ni >= 0 && nj >= 0 && ni < N && nj < M) next = dfs(num,ni,nj);
		if(next != 0 && next != num) count[i][j] = next;
		return next;
	}
}
