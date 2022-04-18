import java.io.*;
import java.util.*;

//고려할 부분
// 1. 자기 자신이 간선으로 주어지는 경우도 있음
// 2. 이미 트리가 아닌 그래프와 합치는 경우도 트리가 아님
public class BOJ_4803_트리 {
	static int N, M;
	static int[] set;
	static boolean[] root;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		String line;
		int tc = 1;

		while (!(line = in.readLine()).equals("0 0")) {
			st = new StringTokenizer(line);
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			set = new int[N + 1];
			root = new boolean[N+1];

			for(int i=1;i<=N;i++) {
				set[i] = i;
				root[i] = true;
			}

			for(int m=0;m<M;m++){
				st = new StringTokenizer(in.readLine());
				union(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			}

			int count = 0;
			for(int i=1;i<=N;i++) if(root[i]) count++;

			sb.append("Case ").append(tc++).append(": ");
			if(count==0) sb.append("No trees.\n");
			else if(count==1) sb.append("There is one tree.\n");
			else sb.append("A forest of ").append(count).append(" trees.\n");
		}

		System.out.print(sb);
	}

	private static void union(int a,int b) {
		int pa = find(a);
		int pb = find(b);
		if(pa==pb) {
			if(a!=b) root[pa] = false;
			return;
		}

		if(pa<pb) {
			set[pb] = pa;
			root[pa] = root[pa]&root[pb];
			root[pb] = false;
		}
		else {
			set[pa] = pb;
			root[pb] = root[pa]&root[pb];
			root[pa] = false;
		}
	}

	private static int find(int x){
		if(set[x]==x) return x;
		return set[x] = find(set[x]);
	}
}
