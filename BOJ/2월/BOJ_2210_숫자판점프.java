import java.io.*;
import java.util.*;

public class BOJ_2210_숫자판점프 {
	static int[][] board = new int[5][5];
	static int[] number = new int[6];
	static int[][] delta = {{1,0},{-1,0},{0,1},{0,-1}};
	static Set<String> set = new HashSet<>();
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int i=0;i<5;i++){
			st = new StringTokenizer(in.readLine());
			for(int j=0;j<5;j++){
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				find(i,j,0);
			}
		}

		System.out.println(set.size());
	}
	public static void find(int i,int j,int cnt){
		if(cnt==6){
			StringBuilder num = new StringBuilder();
			for(int n:number){
				num.append(n);
			}
			set.add(num.toString());
			return;
		}

		number[cnt] = board[i][j];

		for(int d=0;d<4;d++){
			int ni = i+delta[d][0];
			int nj = j+delta[d][1];
			if(ni<0 || nj<0 || ni>=5 || nj>=5) continue;
			find(ni,nj,cnt+1);
		}

	}
}
