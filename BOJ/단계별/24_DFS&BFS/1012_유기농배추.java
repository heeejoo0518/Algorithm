import java.io.*;
import java.util.*;

public class Main{
	static int m,n,k;
	
	static int[] dx = new int[]{0,0,-1,1};
	static int[] dy = new int[]{1,-1,0,0};
	
	static int[][] field;
	static boolean[][] visited;
	
	private static class Points{
		int x;
		int y;
		Points(int x,int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			int result = 0;
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			field = new int[n][m];
			visited = new boolean[n][m];
			
			for(int i=0;i<k;i++) {
				st =  new StringTokenizer(br.readLine()," ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				field[y][x] = 1;
			}
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(field[i][j]==1 && !visited[i][j]) {
						//bfs(j,i);
						dfs(j,i);
						result++;
					}
				}
			}
			sb.append(result+"\n");
		}
		
		br.close();
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	private static void bfs(int x, int y) {
		Queue<Points> queue = new LinkedList<>();
		visited[y][x] = true;
		queue.offer(new Points(x,y));
		
		while(!queue.isEmpty()) {
			x = queue.peek().x;
			y = queue.peek().y;
			
			queue.poll();
			
			for(int i=0;i<4;i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				
				if(checkRange(nx,ny)) {
					queue.offer(new Points(nx,ny));
					visited[ny][nx] = true;
				}
			}
		}
	}
	
	private static void dfs(int x, int y) {
		visited[y][x] = true;
		
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(checkRange(nx,ny)) dfs(nx,ny);
		}
	}
	
	private static boolean checkRange(int x,int y) {
		return x>=0 && x<m && y>=0 && y<n && field[y][x]==1 && !visited[y][x];
	}
}