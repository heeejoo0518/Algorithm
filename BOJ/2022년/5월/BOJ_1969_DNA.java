import java.io.*;
import java.util.*;

public class BOJ_1969_DNA {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] count = new int[4][M];

		char[] dna;
		for(int i=0;i<N;i++){
			dna = in.readLine().toCharArray();
			for(int j=0;j<M;j++){
				switch(dna[j]){
					case 'A':
						count[0][j]++;
						break;
					case 'C':
						count[1][j]++;
						break;
					case 'G':
						count[2][j]++;
						break;
					case 'T':
						count[3][j]++;
						break;
				}
			}
		}

		StringBuilder ans = new StringBuilder();
		int idx;
		int cnt=0;
		for(int i=0;i<M;i++){
			idx = 0;
			for(int j=1;j<4;j++){
				if(count[idx][i]<count[j][i]) {
					idx = j;
				}
			}
			switch(idx){
				case 0:
					ans.append('A');
					break;
				case 1:
					ans.append('C');
					break;
				case 2:
					ans.append('G');
					break;
				case 3:
					ans.append('T');
					break;
			}

			cnt+=N-count[idx][i];
		}

		System.out.println(ans);
		System.out.println(cnt);


	}
}
