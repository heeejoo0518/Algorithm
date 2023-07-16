import java.io.*;

public class BOJ_2448_별찍기11 {
	static boolean[][] board;
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		board = new boolean[N][N*2];

		star(0,0,N);

		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++){
			for(int j=0;j<2*N;j++){
				if(board[i][j]) sb.append('*');
				else sb.append(' ');
			}
			sb.append('\n');
		}

		System.out.print(sb);
	}
	private static void star(int i, int j, int n){
		if(n==3){
			board[i][j+2] = board[i+1][j+1] = board[i+1][j+3] = true;
			for(int k=0;k<5;k++) board[i+2][j+k] = true;
			return;
		}

		star(i,j+n/2,n/2);
		star(i+n/2,j,n/2);
		star(i+n/2,j+n,n/2);
	}
}
