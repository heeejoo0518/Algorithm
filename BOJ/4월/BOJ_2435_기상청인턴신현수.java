import java.io.*;
import java.util.*;

public class BOJ_2435_기상청인턴신현수 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] input = new int[N];
		st = new StringTokenizer(in.readLine());
		for(int i=0;i<N;i++) input[i] = Integer.parseInt(st.nextToken());

		int tmp = 0;
		for(int i=0;i<K;i++) tmp += input[i];

		int max = tmp;
		for(int i=K;i<N;i++){
			tmp -= input[i-K];
			tmp += input[i];
			if(max<tmp) max = tmp;
		}

		System.out.println(max);

	}
}
