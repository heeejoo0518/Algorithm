import java.io.*;
import java.util.*;

public class BOJ_14938_서강그라운드 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		int[] item = new int[N];
		st = new StringTokenizer(in.readLine());
		for(int n=0;n<N;n++) item[n] = Integer.parseInt(st.nextToken());

		int[][] road = new int[N][N];
		for(int n=0;n<N;n++) Arrays.fill(road[n], M+1);

		int a,b,l;
		for(int r=0;r<R;r++){
			st = new StringTokenizer(in.readLine());
			a = Integer.parseInt(st.nextToken())-1;
			b = Integer.parseInt(st.nextToken())-1;
			l = Integer.parseInt(st.nextToken());

			road[a][b] = Math.min(l,road[a][b]);
			road[b][a] = Math.min(l,road[b][a]);
		}

		for(int k=0;k<N;k++){
			for(int i=0;i<N;i++){
				for(int j=0;j<N;j++){
					road[i][j] = Math.min(road[i][j], road[i][k]+road[k][j]);
				}
			}
		}

		int count = 0;
		for(int i=0;i<N;i++){
			int tmp = item[i];
			for(int j=0;j<N;j++){
				if(i==j) continue;
				if(road[i][j] <= M) tmp += item[j];
			}
			count = Math.max(count, tmp);
		}

		System.out.println(count);
	}
}
