import java.io.*;
import java.util.*;

public class BOJ_2630_색종이만들기 {
	static int[][] board;
	static int[] answer;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		board = new int[N][N];
		answer = new int[2];

		StringTokenizer st;
		for(int i=0;i<N;i++){
			st = new StringTokenizer(in.readLine());
			for(int j=0;j<N;j++){
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		cut(0,0,N);

		System.out.println(answer[0]+"\n"+answer[1]);

	}

	public static void cut(int y, int x, int n){
		if(check(y,x,n)){
			answer[board[y][x]]++;
			return;
		}

		cut(y,x,n/2);
		cut(y+n/2,x,n/2);
		cut(y,x+n/2,n/2);
		cut(y+n/2,x+n/2,n/2);
	}

	public static boolean check(int y, int x, int n){
		int first = board[y][x];
		for(int i=y;i<y+n;i++){
			for(int j=x;j<x+n;j++){
				if(first != board[i][j]) return false;
			}
		}
		return true;
	}
}
