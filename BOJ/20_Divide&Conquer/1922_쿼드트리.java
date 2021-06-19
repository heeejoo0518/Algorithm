import java.io.*;
import java.util.*;

public class Main{
	static char[][] video;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		video = new char[n][n];
		for(int i=0;i<n;i++) {
			char[] line= br.readLine().toCharArray();
			for(int j=0;j<n;j++) {
				video[i][j] = line[j];
			}
		}
		br.close();

		bw.write(QuadTree(n,0,0));
		bw.flush();
		bw.close();
	}
	
	public static String QuadTree(int n, int x, int y) {
		char first = video[x][y];
		
		if(n==1) return String.valueOf(first);
		
		for(int i=x;i<x+n;i++) {
			for(int j=y;j<y+n;j++) {
				if(first!=video[i][j]) {
					StringBuilder sb = new StringBuilder("(");
					sb.append(QuadTree(n/2,x,y));
					sb.append(QuadTree(n/2,x,y+n/2));
					sb.append(QuadTree(n/2,x+n/2,y));
					sb.append(QuadTree(n/2,x+n/2,y+n/2));
					sb.append(")");
					return sb.toString();
				}
			}
		}
		
		return String.valueOf(first);
	}
}