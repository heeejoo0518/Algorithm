import java.io.*;

public class BOJ_1254_팰린드롬만들기 {
	static char[] input;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		input = in.readLine().toCharArray();
		N = input.length;

		for(int len = N;len<2*N;len++){
			if(check(len)){
				System.out.println(len);
				return;
			}
		}
	}

	public static boolean check(int len){
		int idx = len/2;
		if(len%2==0) idx-=1;
		for(;idx>=0 && len-1-idx<N;idx--){
			if(input[idx] != input[len-1-idx]) return false;
		}
		return true;
	}
}
