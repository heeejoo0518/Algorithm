import java.io.*;
import java.util.*;

public class Main{
	static int[] result = new int[3];
	static int[][] paper;
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
		
		cutPaper(n,0,0);
		
		bw.write(result[0]+"\n"+result[1]+"\n"+result[2]);
		bw.flush();
		bw.close();
	}
	
	public static void cutPaper(int n, int x, int y) {
		int first = paper[x][y];
		
		if(n==1) {
			result[first+1]++; 
			return;
		}
		
		for(int i=x;i<x+n;i++) {
			for(int j=y;j<y+n;j++) {
				if(first!=paper[i][j]) {
					int next = n/3;
					
					for(int k=0;k<3;k++) {
						for(int l=0;l<3;l++) {
							cutPaper(next,x+next*k,y+next*l);
						}
					}
					
					return;
				}
			}
		}
		
		result[first+1]++; 
		return;
	}
}