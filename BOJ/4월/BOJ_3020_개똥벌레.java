import java.io.*;
import java.util.*;

public class BOJ_3020_개똥벌레 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		int[] fromB = new int[H+1];
		int[] fromT = new int[H+1];

		boolean isB = true;
		int len;
		for (int i = 0; i < N; i++) {
			len = Integer.parseInt(in.readLine());
			if(isB) fromB[len]++;
			else fromT[len]++;
			isB = !isB;
		}

		for(int h=H-1;h>0;h--){
			fromB[h] += fromB[h+1];
			fromT[h] += fromT[h+1];
		}

		int min = 200001, cnt = 0;
		int tmp;
		for(int h=1;h<=H;h++){
			tmp = fromB[h] + fromT[H-h+1];
			if(tmp<min){
				min = tmp;
				cnt = 1;
			}else if(tmp==min) cnt++;
		}

		System.out.println(min+" "+cnt);
	}
}
