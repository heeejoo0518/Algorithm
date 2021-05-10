import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main{
	static char[][] board;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int n = Integer.parseInt(br.readLine());		
		br.close();
		
		board = new char[n][n];
		
		star(0,0,n);
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				sb.append(board[i][j]);
			}
			sb.append("\n");
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		
		bw.flush();
		bw.close();
	}
	
	public static void star(int x, int y, int n) {
		if(n==1) {
			board[y][x] = '*';
			return;
		}		
		
		int div = n/3;
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(i==1 && j==1) {
					space(x+j*div, y+i*div, div);
					continue;
				}
				star(x+j*div, y+i*div, div);
			}
		}
		
	}
	
	public static void space(int x,int y, int n) {
		for(int i=y;i<y+n;i++) {
			for(int j=x;j<x+n;j++) {
				board[i][j] = ' ';
			}
		}
	}
}
