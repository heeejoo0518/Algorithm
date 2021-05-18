import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int n = Integer.parseInt(br.readLine());
		String[] words = new String[n];
		for(int i=0;i<n;i++) {
			words[i] = br.readLine();
		}
		
		br.close();
		
		Arrays.sort(words,new Comparator<String>(){
			@Override
			public int compare(String s1, String s2) {
				if(s1.length()!=s2.length()) return s1.length()-s2.length();
				else return s1.compareTo(s2);
			}
		});
		
		StringBuilder sb = new StringBuilder();		
		for(String s:Arrays.stream(words).distinct().toArray(String[]::new)) {
			sb.append(s+"\n");
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		
		bw.flush();
		bw.close();
	}
}
