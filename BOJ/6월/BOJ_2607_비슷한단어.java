import java.io.*;
import java.util.*;

public class BOJ_2607_비슷한단어 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());

		String str = in.readLine();
		int len = str.length();
		int[] standard = new int[26];
		for(char ch:str.toCharArray()) standard[ch-'A']++;

		int answer = 0;
		int[] compare;
		for(int i=1;i<N;i++){
			str = in.readLine();
			int diff = Math.abs(len-str.length());
			if(diff > 1) continue;

			compare = new int[26];
			for(char ch:str.toCharArray()) compare[ch-'A']++;

			int count = 0;
			for(int j=0;j<26;j++) count += Math.abs(standard[j]-compare[j]);

			if(count == 0 || diff + count == 2) answer++;
		}

		System.out.println(answer);
	}
}
