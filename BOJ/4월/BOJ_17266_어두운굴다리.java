import java.io.*;
import java.util.*;

public class BOJ_17266_어두운굴다리 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int M = Integer.parseInt(in.readLine());
		int[] lights = new int[M];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=0;i<M;i++) lights[i] = Integer.parseInt(st.nextToken());

		int l = 0, r = N+1, m, prev, count;
		while(l<=r){
			m = (l+r)/2;
			prev = 0;
			count = 0;
			for(int light:lights){
				if(light-m > prev) count += light-m-prev;
				prev = light+m;
			}
			if(lights[M-1]+m < N) count += N-lights[M-1]-m;

			if(count > 0){
				l = m+1;
			}else{
				r = m-1;
			}
		}

		System.out.println(l);
	}
}
