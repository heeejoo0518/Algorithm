import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BOJ_1181_단어정렬 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		Set<String> set = new HashSet<>();
		
		//입력
		for(int i=0;i<N;i++) {
			set.add(in.readLine());			
		}
		in.close();
		
		//정렬
		List<String> words = new ArrayList<>(set);
		Collections.sort(words, ((s1,s2)->{
			if(s1.length()==s2.length()) return s1.compareTo(s2);
			return s1.length()-s2.length();
		}));
		
		//출력
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		for(String word:words) {
			out.write(word+"\n");
		}
		out.flush();
		out.close();
	}
}

/*
  중복 삭제하는 다른 방법(Stream)
 
	for(String s:Arrays.stream(words).distinct().toArray(String[]::new)) {
		sb.append(s+"\n");
	}

*/
