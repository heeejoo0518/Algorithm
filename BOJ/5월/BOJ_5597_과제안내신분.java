import java.io.*;

public class BOJ_5597_과제안내신분 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		boolean[] input = new boolean[31];
		for(int i=0;i<28;i++){
			input[Integer.parseInt(in.readLine())] = true;
		}

		for(int i=1;i<=30;i++){
			if(!input[i]){
				System.out.println(i);
			}
		}
	}
}
