import java.io.*;
import java.util.*;

public class Main{
	static int[][] maze;
	static boolean[][] visited;
	static int n,m;
	
	static int[] dx = new int[] {0,0,-1,1};
	static int[] dy = new int[] {-1,1,0,0};
	
	private static class Point{
		int x;
		int y;
		
		Point(int y,int x){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		maze = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i=0;i<n;i++) {
			char[] line = br.readLine().toCharArray();
			for(int j=0;j<line.length;j++) {
				maze[i][j] = Character.getNumericValue(line[j]);
			}
		}
		
		
		br.close();
		
		
		bw.write(String.valueOf(bfs(n-1,m-1)));
		bw.flush();
		bw.close();
	}

	private static int bfs(int i, int j) {
		visited[0][0] = true;
		int result = maze[0][0];
		
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(0,0));
		
		while(!queue.isEmpty()) {
			int x = queue.peek().x;
			int y = queue.peek().y;
			result = maze[y][x];
			queue.poll();
			
			for(int k=0;k<4;k++) {
				int nx = x+dx[k];
				int ny = y+dy[k];
				if(checkRange(ny,nx)) {
					//방문하긴 했으나 result+1보다 클 때, 혹은 방문한 적 없을 때 offer
					if((visited[ny][nx] && maze[ny][nx]>result+1) || !visited[ny][nx]) {
						queue.offer(new Point(ny,nx));
						visited[ny][nx] = true;
						maze[ny][nx] = result+1;
					}
					
				}
			}
		}
		
		return maze[i][j];
		
	}
	private static boolean checkRange(int i,int j) {
		return i>=0 && i<n && j>=0 && j<m && maze[i][j]!=0;
	}
}