import java.io.*;
import java.util.*;

public class BOJ_19637_IF문좀대신써줘 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		List<String> names = new ArrayList<>();
		List<Integer> scores = new ArrayList<>();

		String name;
		int score;
		for(int i=0;i<N;i++){
			st = new StringTokenizer(in.readLine());
			name = st.nextToken();
			score = Integer.parseInt(st.nextToken());
			if(scores.size()>0 && scores.get(scores.size()-1)==score) continue;
			names.add(name);
			scores.add(score);
		}

		//출력하기
		StringBuilder sb = new StringBuilder();
		int input,idx;
		for(int i=0;i<M;i++){
			input = Integer.parseInt(in.readLine());
			idx = Collections.binarySearch(scores,input);
			if(idx<0) idx = -idx-1;
			sb.append(names.get(idx)).append('\n');
		}

		System.out.print(sb);
	}
}
