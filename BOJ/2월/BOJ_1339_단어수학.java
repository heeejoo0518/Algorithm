import java.io.*;
import java.util.*;

public class BOJ_1339_단어수학 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		Map<Character,Integer> map = new HashMap<>();

		char[] word;
		for(int i=0;i<N;i++){
			word = in.readLine().toCharArray();
			int value = (int)Math.pow(10,word.length-1);
			for(int j=0;j<word.length;j++) {
				map.put(word[j], map.getOrDefault(word[j],0)+value);
				value /= 10;
			}
		}

		//value 기준 내림차순정렬
		List<Character> keySet = new ArrayList<>(map.keySet());
		keySet.sort((o1,o2)->map.get(o2)-map.get(o1));

		int answer = 0;
		int number = 9;
		for(Character ch:keySet){
			answer += number*map.get(ch);
			number--;
		}

		System.out.println(answer);
	}
}
