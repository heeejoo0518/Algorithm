import java.io.*;
import java.util.*;

public class BOJ_16194_카드구매하기2 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		int[] card = new int[N+1];
		for(int i=1;i<=N;i++) card[i] = Integer.parseInt(st.nextToken());

		for(int i=2;i<=N;i++){
			for(int j=1;j<=i/2;j++){
				card[i] = Math.min(card[i], card[j] + card[i-j]);
			}
		}

		System.out.println(card[N]);
	}
}
