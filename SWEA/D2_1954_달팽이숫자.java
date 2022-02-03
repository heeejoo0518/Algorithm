import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D2_1954_달팽이숫자 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int[][] deltas = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };// 오른쪽-아래-왼쪽-위

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		int N;
		int[][] snail;
		
		for(int tc = 1;tc<=T;tc++) {
			sb.append("#").append(tc).append("\n");
			
			N = Integer.parseInt(in.readLine());
			snail = new int[N][N];
			
			int y = 0, x = 0;
			int way = 0;
			int num = 0;
			
			while(num<N*N) {
				if(snail[y][x]==0) {
					snail[y][x] = ++num;
				}
				
				int ny = y + deltas[way][0];
				int nx = x + deltas[way][1];
				
				if(ny>=0 && ny < N && nx>=0 && nx<N && snail[ny][nx]==0) {
					y=ny;
					x=nx;
				}else {
					way = (way+1)%4;
				}
			}
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					sb.append(snail[i][j]).append(" ");
				}
				sb.append("\n");
			}
		}
		
		System.out.print(sb);
	}

}
