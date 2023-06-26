import java.io.*;
import java.util.*;

public class BOJ_2470_두용액 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] input = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=0;i<N;i++) input[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(input);

		int min = 2_000_000_001;
		int a=0, b=0;
		int start=0, end=N-1, sum;
		while(start<end){
			sum = input[start]+input[end];
			if(Math.abs(sum)<min){
				min = Math.abs(sum);
				a = input[start];
				b = input[end];
			}
			if(sum>0) end--;//작아져야 함
			else start++;//커져야 함
		}

		System.out.println(a+" "+b);
	}
}
