import java.io.*;
import java.util.*;

public class BOJ_10809_알파벳찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int[] alphabet = new int[26];
		Arrays.fill(alphabet, -1);
		int idx = 0;
		for(char ch:in.readLine().toCharArray()){
			if(alphabet[ch-'a'] == -1) alphabet[ch-'a'] = idx;
			idx++;
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<26;i++) sb.append(alphabet[i]).append(' ');
		System.out.println(sb);
	}
}
