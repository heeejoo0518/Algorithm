import java.io.*;
import java.util.*;

public class BOJ_7662_이중우선순위큐2 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		for(int tc=0;tc<T;tc++){
			int K = Integer.parseInt(in.readLine());
			TreeMap<Integer, Integer> map = new TreeMap<>();
			for(int k=0;k<K;k++){
				st = new StringTokenizer(in.readLine());
				String command = st.nextToken();
				int num = Integer.parseInt(st.nextToken());
				switch (command){
					case "I":
						map.put(num,map.getOrDefault(num,0)+1);
						break;
					case "D":
						if(map.size()==0) break;
						int del = num>0? map.lastKey():map.firstKey();
						int cnt = map.get(del);
						if(cnt==1) map.remove(del);
						else map.put(del,cnt-1);
						break;
				}
			}

			if(map.size()==0) sb.append("EMPTY\n");
			else sb.append(map.lastKey()).append(" ").append(map.firstKey()).append('\n');
		}

		System.out.print(sb);
	}
}
