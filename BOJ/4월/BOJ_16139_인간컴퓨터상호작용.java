import java.io.*;
import java.util.*;

public class BOJ_16139_인간컴퓨터상호작용 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		char[] S = in.readLine().toCharArray();

		//저장
		int[][] count = new int[26][S.length+1];
		for(int i=1;i<=S.length;i++){
			count[S[i-1]-'a'][i]++;
		}

		//누적합
		for(int i=2;i<=S.length;i++){
			for(int j=0;j<26;j++){
				count[j][i] += count[j][i-1];
			}
		}

		//탐색
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int ch,l,r;
		for(int i=0;i<N;i++){
			st = new StringTokenizer(in.readLine());
			ch = st.nextToken().charAt(0)-'a';
			l = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken())+1;

			sb.append(count[ch][r]-count[ch][l]).append('\n');
		}

		System.out.print(sb);
	}
}
