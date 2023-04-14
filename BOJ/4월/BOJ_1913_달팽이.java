import java.io.*;
import java.util.*;

public class BOJ_1913_달팽이 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int M = Integer.parseInt(in.readLine());
		int[][] board = new int[N][N];

		int x = N/2, y = N/2;
		int ansx = 0, ansy = 0;
		int[][] delta = {{-1,0},{0,1},{1,0},{0,-1},{-1,0}};//yx순서
		int d = 4, level = 0, cnt = 0;
		for(int i=1;i<=N*N;i++){
			if(i==M){
				ansx = x+1;
				ansy = y+1;
			}

			board[y][x] = i;
			if(++cnt>=level) {
				cnt = 0;
				d = (d+1)%5;
				if(d==0) {
					level+=2;
					x += delta[d][1];
					y += delta[d][0];
					d++;
					continue;
				}
			}

			x += delta[d][1];
			y += delta[d][0];

		}

		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				sb.append(board[i][j]).append(' ');
			}
			sb.append('\n');
		}

		sb.append(ansy).append(' ').append(ansx);
		System.out.print(sb);
	}
}
