import java.io.*;
import java.util.*;

public class BOJ_1189_컴백홈 {
	static int R,C,K;
	static char[][] map;
	static int count = 0;
	static int[][] deltas = {{1,0},{-1,0},{0,1},{0,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new char[R][C];

		for(int i=0;i<R;i++){
			map[i] = in.readLine().toCharArray();
		}

		map[R-1][0] = 'x';
		dfs(R-1,0, 1);

		System.out.println(count);
	}
	public static void dfs(int r, int c, int cnt){
		if(cnt>K) return;
		if(r==0 && c == C-1){
			if(cnt==K) count++;
			return;
		}

		int nr,nc;
		for(int[] d:deltas){
			nr = r+d[0];
			nc = c+d[1];
			if(nr<0||nc<0||nr>=R||nc>=C||map[nr][nc]!='.') continue;
			map[nr][nc] = 'x';
			dfs(nr,nc,cnt+1);
			map[nr][nc] = '.';
		}
	}
}
