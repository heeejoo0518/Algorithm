import java.io.*;

public class BOJ_16472_고냥이 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		char[] S = in.readLine().toCharArray();
		int[] count = new int[26];

		int max = 0, left = 0, right = 0, cnt = 0;
		while(left<=right && right < S.length){
			if(cnt>N){
				count[S[left]-'a']--;
				if(count[S[left]-'a']==0) cnt--;
				left++;
				continue;
			}
			if(count[S[right]-'a']++ == 0) cnt++;
			if(cnt<=N) max = Math.max(max,right-left+1);
			right++;

		}
		System.out.println(max);
	}
}
