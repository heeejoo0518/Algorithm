import java.io.*;
import java.util.*;

public class BOJ_2206_벽부수고이동하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] deltas = {{1,0},{0,1},{0,-1},{-1,0}};

		char[][] map = new char[N][M];
		for(int i=0;i<N;i++) map[i] = in.readLine().toCharArray();
		int[][][] dist = new int[2][N][M];

		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[]{0,0,0});
		dist[0][0][0] = 1;
		int w,n,m,l,nn,nm;

		while(!queue.isEmpty()){
			w = queue.peek()[0];//벽 부쉈는지
			n = queue.peek()[1];
			m = queue.poll()[2];
			l = dist[w][n][m];//경로길이

			for(int[] d:deltas){
				nn = n+d[0];
				nm = m+d[1];
				if(nn<0 || nn>=N || nm<0 || nm >= M) continue;
				if(map[nn][nm]=='1' && w==0 && dist[1][nn][nm] == 0){
					queue.offer(new int[]{1,nn,nm});
					dist[1][nn][nm] = l+1;
				}else if(map[nn][nm]=='0' && dist[w][nn][nm] == 0){
					queue.offer(new int[]{w,nn,nm});
					dist[w][nn][nm] = l+1;
				}
			}
		}

		if(dist[0][N-1][M-1] == 0 && dist[1][N-1][M-1] == 0) System.out.println(-1);
		else if(dist[0][N-1][M-1] == 0) System.out.println(dist[1][N-1][M-1]);
		else if(dist[1][N-1][M-1] == 0) System.out.println(dist[0][N-1][M-1]);
		else System.out.println(Math.min(dist[0][N-1][M-1],dist[1][N-1][M-1]));
	}
}
