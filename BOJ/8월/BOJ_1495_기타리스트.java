import java.io.*;
import java.util.*;

public class BOJ_1495_기타리스트 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());//곡 개수
		int S = Integer.parseInt(st.nextToken());//시작 볼륨
		int M = Integer.parseInt(st.nextToken());//볼륨 최댓값

		int[] V = new int[N];
		st = new StringTokenizer(in.readLine());
		for(int i=0;i<N;i++) V[i] = Integer.parseInt(st.nextToken());

		boolean[] prev = new boolean[M+1];
		prev[S] = true;

		boolean[] now;
		for(int i=0;i<N;i++){
			now = new boolean[M+1];
			for(int j=0;j<=M;j++){
				if(!prev[j]) continue;
				if(j+V[i] <= M) now[j+V[i]] = true;
				if(j-V[i] >= 0) now[j-V[i]] = true;
			}
			prev = now;
		}

		int volume = -1;
		for(int i=M;i>=0;i--){
			if(prev[i]){
				volume = i;
				break;
			}
		}

		System.out.println(volume);

	}
}
