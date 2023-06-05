import java.io.*;
import java.util.*;

public class BOJ_4358_생태학 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		Map<String, Integer> map = new HashMap<>();
		String str;
		double count = 0;
		while((str = in.readLine()) != null){
			map.put(str, map.getOrDefault(str,0)+1);
			count++;
		}

		ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
		Collections.sort(list,(a,b)->a.getKey().compareTo(b.getKey()));

		StringBuilder sb = new StringBuilder();
		for(Map.Entry<String, Integer> entry:list){
			sb.append(entry.getKey()).append(" ").append(String.format("%.4f",100*entry.getValue()/count)).append('\n');
		}

		System.out.print(sb);
	}
}
