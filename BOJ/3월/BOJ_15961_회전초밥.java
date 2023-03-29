import java.io.*;
import java.util.*;

public class BOJ_15961_회전초밥 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());	//접시 수
		int D = Integer.parseInt(st.nextToken());	//초밥 가짓수
		int K = Integer.parseInt(st.nextToken());	//연속해서 먹는 접시 수
		int C = Integer.parseInt(st.nextToken());	//쿠폰번호

		//벨트에 놓여있는 초밥들
		int[] sushi = new int[N];
		for(int i=0;i<N;i++) sushi[i] = Integer.parseInt(in.readLine());

		//이미 먹은 초밥 종류
		int[] eat = new int[D+1];
		eat[C] = 1;

		//초기화
		int tmp = 1, start, end = K;
		for(start=0;start<end;start++){
			if(eat[sushi[start]]++ == 0) tmp++;
		}
		int max = tmp;

		//탐색
		for(start = 1;start<N;start++, end=(end+1)%N){
			if(--eat[sushi[start-1]]==0) tmp--;
			if(eat[sushi[end]]++ == 0) tmp++;
			if(max<tmp) max = tmp;
		}

		//출력
		System.out.println(max);

	}
}
