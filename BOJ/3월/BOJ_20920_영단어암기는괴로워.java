import java.io.*;
import java.util.*;

public class BOJ_20920_영단어암기는괴로워 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Map<String, Integer> map = new HashMap<>();
		List<String> list = new ArrayList<>();

		String word;
		for (int i = 0; i < N; i++) {
			word = in.readLine();
			if (word.length() < M) continue;
			if (!map.containsKey(word)) {
				list.add(word);
			}
			map.put(word,map.getOrDefault(word,0)+1);
		}

		//자주 나올수록, 단어 길이 길수록, 알파벳 사전순으로 앞에 배치
		Collections.sort(list, (o1, o2) -> {
			if (map.getOrDefault(o1, 0) != map.getOrDefault(o2, 0)) {
				return map.getOrDefault(o2, 0) - map.getOrDefault(o1, 0);
			} else if (o1.length() != o2.length()) {
				return o2.length() - o1.length();
			} else {
				return o1.compareTo(o2);
			}
		});

		StringBuilder sb = new StringBuilder();
		for(String item:list){
			sb.append(item).append('\n');
		}

		System.out.print(sb);
	}
}
