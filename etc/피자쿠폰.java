import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		//n장 쿠폰 / m장 = 몫 : 새로 얻을 피자 및 새로 얻을 쿠폰 수 , 나머지 : 저장
		int ans = N;
		while(N>=M){
			ans += N/M;
			N = N/M + N%M;
		}
		
		System.out.println(ans);
	}
}