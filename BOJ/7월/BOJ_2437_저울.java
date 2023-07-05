import java.io.*;
import java.util.*;

public class BOJ_2437_저울 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] weights = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=0;i<N;i++) {
			weights[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(weights);

		int sum = 0;
		int answer = 0;

		for(int idx=0;idx<N-1;idx++){
			sum += weights[idx];
			if(sum < weights[idx+1]){
				answer = sum+1;
				break;
			}
		}

		if(answer==0) System.out.println(sum+1);
		else System.out.println(answer);
	}
}
