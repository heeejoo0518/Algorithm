import java.io.*;

public class BOJ_17609_회문 {
	static char[] word;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();

		int count;
		for(int i=0;i<N;i++){
			word = in.readLine().toCharArray();
			count = solve(0,word.length-1,0);
			sb.append(count).append('\n');
		}

		System.out.print(sb);
	}

	public static int solve(int left, int right, int count){
		int l = left;
		int r = right;
		while(l<r){
			if(word[l]==word[r]){
				l++; r--;
				continue;
			}

			if(count==1) return 2;
			return Math.min(solve(l,r-1,1), solve(l+1,r,1));
		}

		return count;
	}
}
