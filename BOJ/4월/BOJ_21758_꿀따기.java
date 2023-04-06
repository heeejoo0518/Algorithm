import java.io.*;
import java.util.*;

public class BOJ_21758_꿀따기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());

		int[] input = new int[N+1];
		int[] sum = new int[N+1];

		for(int i=1;i<=N;i++){
			input[i] = Integer.parseInt(st.nextToken());
			sum[i] = sum[i-1]+input[i];
		}

		int max = 0, tmp;
		//벌(벌)꿀통
		tmp = sum[N]+sum[N]-sum[1];
		for(int i=2;i<N;i++){
			max = Math.max(max,tmp - input[i] - sum[i]);
		}

		//벌(꿀통)벌
		tmp = sum[N-1]-input[1];
		for(int i=2;i<N;i++){
			max = Math.max(max,tmp+sum[i]-sum[i-1]);
		}

		//꿀통(벌)벌
		for(int i=2;i<N;i++){
			max = Math.max(max,sum[N-1]-input[i]+sum[i-1]);
		}

		System.out.println(max);
	}
}
