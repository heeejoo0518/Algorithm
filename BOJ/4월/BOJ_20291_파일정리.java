import java.io.*;
import java.util.*;

public class BOJ_20291_파일정리 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		Map<String, Integer> map = new TreeMap<>();
		StringTokenizer st;
		String extension;
		for(int i=0;i<N;i++){
			st = new StringTokenizer(in.readLine(),".");
			st.nextToken();
			extension = st.nextToken();
			map.put(extension,map.getOrDefault(extension,0)+1);
		}
		StringBuilder sb = new StringBuilder();
		for(Map.Entry<String, Integer> entry:map.entrySet()){
			sb.append(entry.getKey()).append(' ').append(entry.getValue()).append('\n');
		}
		System.out.print(sb);
	}
}
