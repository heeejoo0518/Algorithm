import java.io.*;
import java.util.*;

public class Main{
	static int[][] map;
	static boolean[][] visited;
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> result = new ArrayList<>();
		
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		visited = new boolean[n][n];
		
		for(int i=0;i<n;i++) {
			char[] line = br.readLine().toCharArray();
			for(int j=0;j<n;j++) {
				map[i][j] = Character.getNumericValue(line[j]);
			}
		}
		
		br.close();
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(map[i][j]==1 && !visited[i][j]) {
					result.add(dfs(i,j));
				}
			}
		}
		
		Collections.sort(result);
		sb.append(result.size()+"\n");
		for(int res:result) {
			sb.append(res+"\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	private static int dfs(int x, int y) {
		if(!checkRange(x,y)) return 0;
		
		visited[x][y] = true;
		int result = 1;
		
		if(checkRange(x,y-1)) result += dfs(x, y-1);
		if(checkRange(x,y+1)) result += dfs(x, y+1);
		if(checkRange(x-1,y)) result += dfs(x-1, y);
		if(checkRange(x+1,y)) result += dfs(x+1, y);
		
		return result;
	}
	
	private static boolean checkRange(int i, int j) {
		return i>=0 && i<n && j>=0 && j<n && map[i][j]==1 && !visited[i][j];
	}
}