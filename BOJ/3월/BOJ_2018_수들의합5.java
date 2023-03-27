import java.io.*;

public class BOJ_2018_수들의합5 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int answer = 0;
		int sum;
		for(int start = 1;start<=N>>1;start++){
			sum = start;
			for(int plus = start+1;sum<N;plus++){
				sum += plus;
				if(sum==N) answer++;
			}
		}

		System.out.println(answer + 1);//N은 N으로 나타낼 수 있음(경우의수 +1)
	}
}
