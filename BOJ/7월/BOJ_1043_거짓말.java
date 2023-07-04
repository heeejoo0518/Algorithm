import java.io.*;
import java.util.*;

public class BOJ_1043_거짓말 {
	static int[] root;
	static ArrayList<Integer> party;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		root = new int[N+1];
		for(int i=1;i<=N;i++) root[i] = i;

		st = new StringTokenizer(in.readLine());
		int K = Integer.parseInt(st.nextToken());
		ArrayList<Integer> know = new ArrayList<>();
		for(int i=0;i<K;i++) know.add(Integer.parseInt(st.nextToken()));

		party = new ArrayList<>();
		int CNT, first;
		for(int i=0;i<M;i++){
			st = new StringTokenizer(in.readLine());
			CNT = Integer.parseInt(st.nextToken());
			first = find(Integer.parseInt(st.nextToken()));
			for(int c=1;c<CNT;c++) union(first, Integer.parseInt(st.nextToken()));
			party.add(first);
		}

		boolean[] check = new boolean[N+1];
		for(int k:know) check[find(k)] = true;

		int count = 0;
		for(int p:party){
			if(!check[find(p)]) count++;
		}

		System.out.println(count);
	}

	private static int find(int x){
		if(root[x]==x) return x;
		return root[x] = find(root[x]);
	}

	private static void union(int a, int b){
		int ra = find(a);
		int rb = find(b);
		if(ra==rb) return;

		root[ra] = rb;
	}
}
