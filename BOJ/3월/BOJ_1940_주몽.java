import java.io.*;
import java.util.*;

public class BOJ_1940_주몽 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int M = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		int[] input = new int[N];
		for(int i=0;i<N;i++) input[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(input);

		int count = 0, left = 0, right = N-1;
		int check;
		while(left<right){
			check = input[left]+input[right];
			if (check == M) {
				count++;
				left++;
				right--;
			}else if(check<M){
				left++;
			}else{
				right--;
			}
		}

		System.out.println(count);
	}
}
