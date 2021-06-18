import java.io.*;
import java.util.*;

public class Main{
	static int[][] paper;
	static int[] result = new int[2];//0 하얀색 1 파란색
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		paper = new int[n][n];
		
		StringTokenizer st;
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<n;j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		br.close();
		
		slicePaper(n,0,0);
		
		bw.write(result[0]+"\n"+result[1]);
		bw.flush();
		bw.close();
	}
	
	public static void slicePaper(int n, int x, int y) {
		int first = paper[x][y];
		
		if(n==1) {
			result[first]++;
			return;
		}
		
		for(int i=x;i<x+n;i++) {
			for(int j=y;j<y+n;j++) {
				if(first!=paper[i][j]) {
					int nextN = n/2;
					slicePaper(nextN,x,y);
					slicePaper(nextN,x+nextN,y);
					slicePaper(nextN,x,y+nextN);
					slicePaper(nextN,x+nextN,y+nextN);
					return;
				}
			}
		}
		
		result[first]++;
	}
}