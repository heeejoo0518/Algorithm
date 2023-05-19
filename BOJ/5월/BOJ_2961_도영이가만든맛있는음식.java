import java.io.*;
import java.util.*;

public class BOJ_2961_도영이가만든맛있는음식 {
	static int N;
	static int[][] ingredient;
	static int MIN = 1_000_000_000;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		ingredient = new int[N][2];
		StringTokenizer st;
		for(int i=0;i<N;i++){
			st = new StringTokenizer(in.readLine());
			ingredient[i][0] = Integer.parseInt(st.nextToken());
			ingredient[i][1] = Integer.parseInt(st.nextToken());
		}

		choose(0,0);
		System.out.println(MIN);
	}

	public static void choose(int choice, int idx){
		if(idx==N){
			if(choice == 0) return;
			MIN = Math.min(MIN, cook(choice));
			return;
		}

		choose(choice, idx+1);
		choose(choice|1<<idx, idx+1);
	}

	public static int cook(int choice){
		int sour = 1;
		int bitter = 0;

		for(int i=0;i<N;i++){
			if((choice&(1<<i)) == 0) continue;
			sour *= ingredient[i][0];
			bitter += ingredient[i][1];
		}

		return Math.abs(sour-bitter);
	}
}
