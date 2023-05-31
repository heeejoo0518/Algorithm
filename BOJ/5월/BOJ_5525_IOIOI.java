import java.io.*;

public class BOJ_5525_IOIOI {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int M = Integer.parseInt(in.readLine());
		char[] S = in.readLine().toCharArray();

		int answer = 0;
		int end = M-N*2-1;
		for(int start = 0;start<=end;start++){
			if(S[start]=='O') continue;
			int count = 0;
			while(start+2<M && S[start+1]=='O' && S[start+2]=='I'){
				if(++count>=N) answer++;
				start += 2;
			}
		}

		System.out.println(answer);
	}
}
