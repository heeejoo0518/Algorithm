import java.io.*;
import java.util.*;

public class BOJ_1062_가르침 {
	static int ANSWER = 0;
	static int[] words;
	static int N,K;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		words = new int[N];
		for(int i=0;i<N;i++){
			for(char ch:in.readLine().toCharArray()){
				words[i]|=1<<ch-'a';
			}
		}

		if(K<5){
			System.out.println("0");
			return;
		}

		//a n t i c
		pick(5,0,1|(1<<'n'-'a')|(1<<'t'-'a')|(1<<'i'-'a')|(1<<'c'-'a'));
		System.out.println(ANSWER);

	}

	public static void pick(int cnt, int start, int flag){
		if(cnt==K){
			check(flag);
			return;
		}

		for(int i=start;i<26;i++){
			if((flag&1<<i)!=0) continue;
			pick(cnt+1,i+1,flag|1<<i);
		}
	}

	public static void check(int flag){
		int count = 0;
		for(int i=0;i<N;i++){
			if(((flag|words[i])^flag) == 0) count++;
		}

		ANSWER = Math.max(ANSWER,count);
	}
}
