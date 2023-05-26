import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_3055_탈출2 {
	static int R,C;
	static char[][] map;
	static int[][] deltas = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];

		Deque<int[]> deque = new ArrayDeque<>();

		for (int r = 0, c = 0; r < R; r++, c = 0) {
			for (char ch : in.readLine().toCharArray()) {
				if (ch == 'S') {
					deque.offerLast(new int[]{r,c,'S'});
				} else if (ch == '*') {
					deque.offerFirst(new int[]{r,c,'*'});
				}
				map[r][c++] = ch;
			}
		}

		int answer = BFS(deque);
		if(answer < 0) System.out.println("KAKTUS");
		else System.out.println(answer);
	}

	private static boolean isValid(int nr, int nc){
		return nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] != 'X';
	}

	private static int BFS(Deque<int[]> deque){
		int[] now;
		int nr, nc;
		int answer = 0;
		while(!deque.isEmpty()){
			answer++;
			for(int s=0, size=deque.size();s<size;s++){
				now = deque.poll();
				for (int[] d : deltas) {
					nr = now[0] + d[0];
					nc = now[1] + d[1];
					if(!isValid(nr,nc)) continue;
					if(map[nr][nc] == '.'){
						map[nr][nc] = (char)now[2];
						deque.offer(new int[]{nr,nc,now[2]});
					}else if(map[nr][nc]=='D' && now[2]=='S'){
						return answer;
					}
				}
			}
		}

		return -1;
	}
}
